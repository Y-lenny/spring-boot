package org.springframework.boot.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 11114396
 */
@Data
public class Result<T> implements Serializable {

	private String code;
	private String desc;
	private T data;

	public static Result newInstance(String code, String desc) {
		Result result = new Result();
		result.setCode(code);
		result.setDesc(desc);

		return result;
	}
}
