package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Ron
 * @Create: 2023-03-23 19:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private Integer age;

    public void show(){
        System.out.println("你好，我是圣诞老人");
    }

}
