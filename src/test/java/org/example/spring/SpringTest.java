package org.example.spring;

import org.example.Person;
import org.example.config.MainConfig;
import org.example.config.MainConfig2;
import org.example.config.MainConfig4;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author: Ron
 * @Create: 2023-05-23 14:48
 */
public class SpringTest {


    /**
     * 测试方法test01，测试从应用上下文中获取Bean的实例。
     * 该函数不接受参数，也不返回值，但会打印出获取到的Person实例的信息。
     */
    @Test
    public void test01(){
        // 创建一个ClassPathXmlApplicationContext实例，加载名为"beans.xml"的应用上下文配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        // 从应用上下文中获取名为"person"的Bean实例
        Person person = (Person) applicationContext.getBean("person");

        // 打印person实例的信息
        System.out.println(person);
    }

    /**
     * 测试方法test02，用于验证通过注解配置的ApplicationContext是否能正确获取Bean。
     * 该方法不接受参数，也没有返回值。
     * 主要步骤包括：
     * 1. 创建AnnotationConfigApplicationContext，并通过MainConfig类进行配置加载；
     * 2. 从ApplicationContext中获取名为"person"的Bean；
     * 3. 打印该Bean的信息。
     */
    @Test
    public void test02(){
        // 创建ApplicationContext，并以MainConfig为配置源
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        // 从ApplicationContext中获取名为"person"的Bean
        Person person = (Person) applicationContext.getBean("person");
        // 打印获取到的Bean信息
        System.out.println(person);
    }

    /**
     * 测试方法test03
     * @ComponentScan(value = "org.example")
     */
    @Test
    public void test03(){
        // 创建一个注解配置的Spring应用上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        // 获取当前应用上下文中所有bean定义的名称
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        // 遍历并打印出所有bean定义的名称
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 测试方法test04
     * @ComponentScan(value = "org.example", includeFilters = {
     *         @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {org.springframework.stereotype.Controller.class}),
     *         @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
     * }, useDefaultFilters = false)
     *
     */
    @Test
    public void test04() {
        // 创建一个注解配置的Spring应用上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        // 获取当前应用上下文中所有bean定义的名称
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        // 遍历并打印出所有bean定义的名称
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 测试Spring容器中的scope和prototype
     */
    @Test
    public void test05() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Person person = (Person) applicationContext.getBean("person");
        Person person1 = (Person) applicationContext.getBean("person");

        System.out.println(person == person1);

    }


    /**
     * 测试@condition注解
     */
    @Test
    public void test06() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);

    }

    /**
     * 测试@import注解
     * @Import[快速给容器中导入一个组件]
     * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
     * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     *
     */
    @Test
    public void test07() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }





}
