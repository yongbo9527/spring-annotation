package org.example.config;

import org.example.bean.Car;
import org.example.bean.Dog;
import org.example.impl.Gunship;
import org.example.impl.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Ron
 * @Create: 2023-05-25 14:05
 */
public class MainConfigOfLifeCycle {
//    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

//    @Bean
    public Gunship gunship(){
        return new Gunship();
    }

    @Bean
    public Dog dog(){
        return new Dog();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}
