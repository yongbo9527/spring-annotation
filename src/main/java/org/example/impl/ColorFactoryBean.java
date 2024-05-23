package org.example.impl;

import org.example.bean.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 * T（泛型）：指定我们要创建什么类型的对象
 * @Author: Ron
 * @Create: 2023-05-24 18:28
 */
public class ColorFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        //放回一个Color对象，这个对象会添加到容器中
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是单例么
    //如果返回true，那么代表这个bean是单实例，在容器中只会保存一份
    //如果返回false，那么代表这个bean是多实例，每次获取都会创建一个新的bean
    @Override
    public boolean isSingleton() {
        return true;
    }
}
