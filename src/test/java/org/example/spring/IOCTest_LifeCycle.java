package org.example.spring;

import org.example.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Ron
 * @Create: 2023-05-25 14:07
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
        applicationContext.close();
    }

    @Test
    public void test02() {
        //创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
//        String[] names = applicationContext.getBeanDefinitionNames();
//        for (String name:names){
//            System.out.println(name);
//        }
        //调用创建对象
        Object gunship = applicationContext.getBean("gunship");
        //关闭容器
        applicationContext.close();
    }

    @Test
    public void test03() {
        //创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        applicationContext.getBean("gunship");
        System.out.println("容器创建完成");
        applicationContext.close();
    }

}
