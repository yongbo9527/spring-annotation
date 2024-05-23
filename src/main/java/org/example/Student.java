package org.example;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Ron
 * @Create: 2023-05-22 18:02
 */
public class Student extends Person {
    public Student(String name, Integer age) {
        super(name, age);
    }

    public static void main(String[] args) {
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1");
//        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        ArrayList<Object> objects = new ArrayList<>();
//        List<String> simpleList = List.of("Hello","world");
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");
        map.put("6", "1");
        map.put("7", "1");
        map.put("8", "1");
        map.put("9", "1");
        map.put("10", "1");
        map.put("11", "1");
        map.put("12", "1");
        map.put("13", "1");
        map.put("14", "1");
//        new Thread().start();
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        HashSet<Object> objects1 = new HashSet<>();
//        objects1.add("1");

        System.currentTimeMillis();



    }
}
