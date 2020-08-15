package com.jwt.filter;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Decription：mvc拦截器配置
 * @Author： huang_guoqiang
 * @Date 2019年05月05日 13:50
 * @Version 1.0
 */
@Configuration
public class MyWebConfigurer extends WebMvcConfigurationSupport {

    /**
     * 这里这么做是为了提前加载, 防止过滤器中@AutoWired注入为空
     * @return
     */
    @Bean
    public AuthenticationInterceptor jwtInterceptor(){
        return new AuthenticationInterceptor();
    }

    /**
     * 自定义过滤规则
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor()).addPathPatterns("/**");
    }

}
