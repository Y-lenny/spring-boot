package org.springframework.boot.example.entity;

import lombok.Data;

/**
 * <b>实体类</b>
 *
 * @author 11114396 lvyongwen
 * @date 2020-12-30 15:57
 * @since 1.0
 */
@Data
public class Girl {

	/**
	 * 姓名
	 */
	private String username;

	/**
	 * 性别
	 */
	private String sex;
}
