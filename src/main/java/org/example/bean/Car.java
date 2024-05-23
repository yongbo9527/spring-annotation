package org.example.bean;

/**
 * @Author: Ron
 * @Create: 2023-05-25 14:06
 */
public class Car {

    public Car(){
        System.out.println("car constructor ...");
    }
    public void init(){
        System.out.println("car init ...");
    }
    public void destroy(){
        System.out.println("car destroy ...");
    }
}
