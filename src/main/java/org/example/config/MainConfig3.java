package org.example.config;

import org.example.Person;
import org.example.bean.Color;
import org.example.impl.ColorFactoryBean;
import org.example.impl.MyImportBeanDefinitionRegistrar;
import org.example.impl.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @Author: Ron
 * @Create: 2023-05-24 17:31
 */
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig3 {

    @Bean
    public Person person(){
        System.out.println("给容器添加 Person 对象");
        return new Person("Leon", 19);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
