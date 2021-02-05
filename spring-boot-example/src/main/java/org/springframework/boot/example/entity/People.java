package org.springframework.boot.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>description</b>
 *
 * @author 11114396 lvyongwen
 * @date 2021-02-04 21:38
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {

	private int sex;

	private String name;

	private String drlType;
}
