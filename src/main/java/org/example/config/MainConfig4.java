package org.example.config;

import org.example.impl.ColorFactoryBean;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Ron
 * @Create: 2023-05-25 11:13
 */
public class MainConfig4 {
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
