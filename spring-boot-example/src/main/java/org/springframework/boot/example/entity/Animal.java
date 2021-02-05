package org.springframework.boot.example.entity;

import lombok.Data;

import java.util.List;

/**
 * <b>动物</b>
 *
 * @author 11114396 lvyongwen
 * @date 2021-02-05 15:14
 * @since 1.0
 */
@Data
public class Animal {

	private Integer level;

	private List<People> peoples;
}
