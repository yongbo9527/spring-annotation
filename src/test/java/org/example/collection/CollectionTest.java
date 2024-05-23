package org.example.collection;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Ron
 * @Create: 2023-07-03 17:23
 */
public class CollectionTest {

    @Test
    public void test01(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("hello","world");
    }

    @Test
    public void test02(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
    }

    /**
     * ConcurrentHashMap 测试
     */
    @Test
    public void test03(){
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("name","Tom");
        String s = concurrentHashMap.get("name");
    }

    @Test
    public void test04(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Tom");
        map.put(null, null);
    }

    /**
     * 使用Java 8的Stream API计算日期范围内的每一天
     */
    @Test
    public void test05(){
        // 示例日期格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("alexanderwang");

        // 示例日期范围，开始和结束日期
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 1, 10);

        // 计算日期范围内的每一天，并按照指定格式转换为字符串
        List<String> dates = Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(endDate.toEpochDay() - startDate.toEpochDay() + 1)
                .map(date -> date.format(formatter)) // 使用formatter格式化日期
                .collect(Collectors.toList());

        // 输出结果
        dates.forEach(System.out::println);
    }

    @Test
    public void test06(){
        List<CompletableFuture<String>> list = new ArrayList<>();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "world";
        });
        list.add(future1);
        list.add(future2);

        CompletableFuture[] array = list.toArray(new CompletableFuture[0]);
        CompletableFuture.allOf(array).join();
        System.out.println(array.length);
    }

    @Test
    public void test07() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");

        String[] array = list.toArray(new String[2]);
        System.out.println(array.length);

        String[] array2 = new String[2];
        array2[0] = "hello";
        array2[1] = "world";
        array2[2] = "world";
        System.out.println(array2.length);


    }


}
