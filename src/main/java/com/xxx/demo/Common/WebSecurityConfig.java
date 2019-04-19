package com.xxx.demo.Common;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    public static final String SESSION_KEY = "user";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        // 排除配置--对下面的不进行拦截
        addInterceptor.excludePathPatterns("/");
        addInterceptor.excludePathPatterns("/api/admin/**");
        addInterceptor.excludePathPatterns("/api/user/**");
        addInterceptor.excludePathPatterns("/api/device/**");
        addInterceptor.excludePathPatterns("/api/solution/**");
        addInterceptor.excludePathPatterns("/api/record/**");
        addInterceptor.excludePathPatterns("/static/**");
        // 增加拦截配置
        addInterceptor.addPathPatterns("/**");
    }
}