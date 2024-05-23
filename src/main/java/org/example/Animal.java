package org.example;

/**
 * @Author: Ron
 * @Create: 2023-05-22 18:21
 */
public abstract class Animal {

    public abstract void eat();

    public void run(){
        System.out.println("Animal run");
    }

    public void sleep(){
        System.out.println("Animal sleep");
    }
}
