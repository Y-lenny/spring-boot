package org.springframework.boot.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b>实体类</b>
 *
 * @author 11114396 lvyongwen
 * @date 2020-12-30 15:57
 * @since 1.0
 */
@Data
@TableName("t_girl")
public class Girl {

	@TableId(value = "id",type = IdType.AUTO)
	private Long id;

	/**
	 * 昵称
	 */
	@TableField("username")
	private String username;

	/**
	 * 性别
	 */
	@TableField("sex")
	private String sex;
}
