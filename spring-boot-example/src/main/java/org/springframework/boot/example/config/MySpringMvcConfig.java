package org.springframework.boot.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class MySpringMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
				System.out.println("自定义拦截器。。。");
				return true;
			}

			@Override
			public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

			}

			@Override
			public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

			}
		};

		// 添加拦截器并设置拦截规则
		registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
	}

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
