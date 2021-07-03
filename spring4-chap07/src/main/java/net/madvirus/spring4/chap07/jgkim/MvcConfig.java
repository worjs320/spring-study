package net.madvirus.spring4.chap07.jgkim;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfig {

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

}
