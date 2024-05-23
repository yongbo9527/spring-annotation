package org.example.config;

import org.example.Person;
import org.example.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @ComponentScan  value:指定要扫描的包
 * excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
 * includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
 * FilterType.ANNOTATION：按照注解
 * FilterType.ASSIGNABLE_TYPE：按照给定的类型；
 * FilterType.ASPECTJ：使用ASPECTJ表达式
 * FilterType.REGEX：使用正则指定
 * FilterType.CUSTOM：使用自定义规则
 * @Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
 */

/**
 * @Author: Ron
 * @Create: 2023-03-23 19:55
 */
//@Configuration //告诉spring这个是配置类 test02
//@ComponentScan(value = "org.example") // value指定要扫描的包 test03
/*@ComponentScan(value = "org.example",
    excludeFilters = {
        //type:指定要排除的规则，是按照注解进行排除，还是按照给定的类型进行【排除，还是按照正则表达式进行排除，等等
        //classes：除了@Controller和@Service标注的组件外，IOC容器中剩下的组件我都要，即相当于我要排除@Controller和@Service这两个注解标注的组件
        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes={Controller.class, Service.class})
})*/
@ComponentScan(value = "org.example", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {org.springframework.stereotype.Controller.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
//        @ComponentScan.Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class}),
}, useDefaultFilters = false) // includeFilters：指定要包含的规则 test04 ASSIGNABLE_TYPE: 指定类型过滤器,包括所有子类

public class MainConfig {

    // @Bean注解是给IOC容器注册一个bean,类型自然就是放回值的类型,id默认的是使用方法名称作为id
    @Bean("person-Ron")
    public Person person1(){
        return new Person("Ron", 18);
    }

    @Bean
    public Person person(){
        return new Person("Leon", 19);
    }
}
