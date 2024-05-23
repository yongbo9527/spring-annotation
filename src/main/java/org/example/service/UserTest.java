package org.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: Ron
 * @Create: 2023-06-12 17:07
 */
public class UserTest {
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new HashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static void main(String[] args) {
        User user0 = new User(1, "Ron", 100, 1);
        User user1 = new User(1, "Ron", 100, 1);
        User user2 = new User(2, "Tony", 99, 3);
        User user3 = new User(3, "Tom", 98, 4);
        List<User> list = new ArrayList<>();
        list.add(user0);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        List<User> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

//        Map<Integer, Integer> sumScoresById = list.stream()
//                .collect(Collectors.groupingBy(User::getId, Collectors.summingInt(User::getScore)));
//
//        Map<Integer, Integer> sumNumbersById = list.stream()
//                .collect(Collectors.groupingBy(User::getId, Collectors.summingInt(User::getNumber)));
//        Map<Integer, String> collect = list.stream().filter(distinctByKey(User::getId)).collect(Collectors.toMap(User::getId, User::getName));
//        System.out.println();


//        List<User> userList = list.stream()
//                .collect(Collectors.groupingBy(User::getId, Collectors.summingInt(User::getScore)))
//                .entrySet()
//                .stream()
//                .map(entry -> new User(entry.getKey(), "", entry.getValue(),
//                        list.stream()
//                                .filter(user -> user.getId().equals(entry.getKey()))
//                                .mapToInt(User::getNumber)
//                                .sum()))
//                .collect(Collectors.toList());
//
//        // Print the new userList
//        for (User userItem : userList) {
//            System.out.println("ID: " + userItem.getId() + ", Score Sum: " + userItem.getScore() +
//                    ", Number Sum: " + userItem.getNumber()+ ", Name: " + userItem.getName());
//        }

    }
}
