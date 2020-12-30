package org.springframework.boot.example.utils;

import org.springframework.boot.example.entity.Result;

/**
 * <b>结果工具类</b>
 *
 * @author 11114396 lvyongwen
 * @date 2020-12-30 16:06
 * @since 1.0
 */
public class ResultUtils {

	public static Result error(String code, String defaultMessage) {
		return Result.newInstance(code, defaultMessage);
	}

	public static Result success() {
		return Result.newInstance("200", "成功");
	}
}
