package org.example.impl;

import org.example.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: Ron
 * @Create: 2023-05-24 18:15
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    /**
     * AnnotationMetadata：当前类的注解信息
     * BeanDefinitionRegistry:BeanDefinition注册类；
     * 		把所有需要添加到容器中的bean；调用
     * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean yellow = registry.containsBeanDefinition("org.example.bean.Yellow");
        boolean blue = registry.containsBeanDefinition("org.example.bean.Blue");
        if (yellow && blue){
            // 指定bean的定义信息，包括bean的类型，作用域等等
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            // 注册一个bean，并且指定bean的名称
            registry.registerBeanDefinition("rainBow",beanDefinition);

        }
    }
}
