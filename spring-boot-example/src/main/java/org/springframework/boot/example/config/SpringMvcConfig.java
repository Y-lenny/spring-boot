package org.springframework.boot.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * <b>自定义拦截器</b>
 * <p>
 * 原本继承{@link org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter},由于jdk8有了default定义接口方法所以直接实现{@link WebMvcConfigurer}即可。
 *
 * @author 11114396 lvyongwen
 * @date 2020-12-30 14:33
 * @since 1.0
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

	/**
	 * spring boot默认就有消息转化器，其编码格式为utf-8
	 *
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		converters.add(stringHttpMessageConverter);
	}
}
