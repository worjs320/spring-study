package net.madvirus.spring4.chap07.jgkim;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jgkim/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public JgkimController jgkimController() {
        return new JgkimController();
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("message.error");
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    @Bean
    public CommonException commonException() {
        return new CommonException();
    }

    @Bean
    public HandlerInterceptorTest handlerInterceptorTest() {
        return new HandlerInterceptorTest();
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(handlerInterceptorTest()).addPathPatterns("/**");
    }
}
