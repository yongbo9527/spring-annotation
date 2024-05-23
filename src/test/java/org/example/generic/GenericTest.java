package org.example.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Ron
 * @Create: 2023-11-13 18:26
 */
public class GenericTest {

    @Test
    public void test01() {

        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(49);
        list.add(72);
        list.add(81);
        list.add(89);
        //问题一：类型不安全
        list.add("Tom");
        System.out.println(list);
        for (Object o : list) {
            //问题二：强转时，可能出现ClassCastException
            int score = (int) o;
            System.out.println(score);
        }
    }

    @Test
    public void test02(){
        ArrayList<?> list = new ArrayList<>();
//        list.add(1);
    }

    @Test
    public void test03(){
        // extends：使用时指定的类型必须是继承某个类，或者实现某个接口，即<=
        // 下限super：使用时指定的类型不能小于操作的类，即>=

        // <?extends Number> (无穷小, Number]
        // 只允许泛型为Number及Number子类的引用调用
        // <? super Number> [Number , 无穷大)
        // 只允许泛型为Number及Number父类的引用调用

        // <? extends Comparable>
        // 只允许泛型为实现Comparable接口的实现类的引用调用
    }
}
