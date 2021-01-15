package org.springframework.boot.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.example.entity.Girl;
import org.springframework.boot.example.entity.Result;
import org.springframework.boot.example.service.GirlService;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <b>Restful controller</b>
 *
 * @author 11114396 lvyongwen
 * @date 2020-12-30 15:53
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/girls")
@Slf4j
public class GirlController {

	@Autowired
	private GirlService girlService;

	/**
	 * add a girl
	 * @return
	 */
	@PostMapping
	public Result<Object> girlAdd(@RequestBody @Valid Girl girl, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return Result.fail("-1","失败");
		}

		girlService.save(girl);

		return Result.success(girl);
	}
}
