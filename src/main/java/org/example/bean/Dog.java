package org.example.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: Ron
 * @Create: 2023-05-25 14:23
 */
public class Dog {
    public Dog(){
        System.out.println("dog constructor...");
    }

    // Constructor（构造方法）→ @Autowired（依赖注入）→ @PostConstruct（注释的方法）
    @PostConstruct
    public void init(){
        System.out.println("dog @PostConstruct...");
    }

    // 调用destroy（）方法 → @PreDestroy → destroy（）方法 → bean销毁
    @PreDestroy
    public void destroy(){
        System.out.println("dog @PreDestroy...");
    }
}
