package org.springframework.boot.example.controller;

import org.springframework.boot.example.entity.Girl;
import org.springframework.boot.example.entity.Result;
import org.springframework.boot.example.utils.ResultUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <b>Restful controller</b>
 *
 * @author 11114396 lvyongwen
 * @date 2020-12-30 15:53
 * @since 1.0
 */
@RestController
public class GirlController {

	/**
	 * add a girl
	 * @return
	 */
	@PostMapping(value = "/girls")
	public Result<Void> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtils.error("-1", bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtils.success();
	}
}
