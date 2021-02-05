package org.springframework.boot.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.example.entity.Animal;
import org.springframework.boot.example.entity.People;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>description</b>
 *
 * @author 11114396 lvyongwen
 * @date 2021-02-04 21:44
 * @since 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class DroolsApplicationTests {

	@Autowired
	private KieSession session;

	@Autowired
	private KieBase kieBase;


	@Test
	public void people() {

		People people = new People();
		people.setName("达");
		people.setSex(1);
		people.setDrlType("people");
		session.insert(people);//插入
		session.fireAllRules();//执行规则
	}

	@Test
	public void animal() {

		Animal animal1 = new Animal();
		animal1.setLevel(1);
		Animal animal2 = new Animal();
		animal2.setLevel(3);
		List<People> peoples = new ArrayList<People>();
		People people1 = new People(1, "达", "from");
		People people2 = new People(2, "达", "from");
		People people3 = new People(3, "达", "collect");
		People people4 = new People(4, "达", "collect");
		peoples.add(people1);
		peoples.add(people2);
		peoples.add(people3);
		peoples.add(people4);
		animal1.setPeoples(peoples);
		session.insert(animal1);//插入
		session.insert(animal2);//插入
		session.insert(people1);//插入
		session.insert(people2);//插入
		session.insert(people3);//插入
		session.insert(people4);//插入
		session.fireAllRules();//执行规则
	}

	@Test
	public void rhs(){

		People people = new People();
		people.setName("达");
		people.setSex(0);
		people.setDrlType("update");
		session.insert(people);//插入
		session.fireAllRules();//执行规则
	}

	@Test
	public void header(){

		People people = new People();
		people.setName("达");
		people.setSex(1);
		people.setDrlType("global");
		// 设置全局变量
		session.setGlobal("list",new ArrayList<People>());
		session.insert(people);//插入
		session.fireAllRules();//执行规则
	}

	@Test
	public void query(){
		People people1 = new People(1, "达", "from");
		People people2 = new People(2, "达", "from");
		People people3 = new People(3, "达", "collect");
		People people4 = new People(4, "达", "collect");

		session.insert(people1);
		session.insert(people2);
		session.insert(people3);
		session.insert(people4);

		QueryResults queryResultsRows = session.getQueryResults("queryPeople","达",2);
		queryResultsRows.forEach(queryResultsRow -> {
			System.out.println(queryResultsRow.get("$p"));;
		});
	}

	@Test
	public void declare() throws IllegalAccessException, InstantiationException {
		FactType factType = kieBase.getFactType("org.example.rules","Love");
		Object object  = factType.newInstance();
		factType.set(object,"feel","love");
		factType.set(object,"continue","forever");

		System.out.println(factType);
	}



	@AfterEach
	public void runDispose() {
		session.dispose();//释放资源
	}
}
