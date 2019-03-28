package com.denny.springbootadvance;

import com.denny.springbootadvance.fliter.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootAdvanceApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdvanceApplication.class, args);
	}

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    MyFilter myFilter = new MyFilter();
    registry.addInterceptor(myFilter).addPathPatterns("/intercept/**");
  }
}
