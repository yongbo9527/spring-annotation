package org.example.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author: Ron
 * @Create: 2023-05-25 14:09
 */
public class Gunship implements InitializingBean, DisposableBean {
    /*会在bean创建完成，并且属性都赋好值以后进行调用*/
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Gunship afterPropertiesSet ...");
    }

    /*会在容器关闭的时候进行调用*/
    @Override
    public void destroy() throws Exception {
        System.out.println("Gunship destroy ...");
    }
}
