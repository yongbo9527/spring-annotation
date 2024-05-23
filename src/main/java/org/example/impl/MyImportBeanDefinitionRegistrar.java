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
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean yellow = registry.containsBeanDefinition("com.test.anno.bean.Yellow");
        boolean blue = registry.containsBeanDefinition("com.test.anno.bean.Blue");
        if (yellow && blue){
//            指定bean的定义信息，包括bean的类型，作用域等等
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
//            注册一个bean，并且指定bean的名称
            registry.registerBeanDefinition("com.test.anno.bean.RainBow",beanDefinition);

        }
    }
}
