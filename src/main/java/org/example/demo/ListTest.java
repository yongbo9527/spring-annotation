package org.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ron
 * @Create: 2023-07-18 20:49
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        Integer[] array = list.toArray(new Integer[0]);
        System.out.println(array.length);
    }
}
