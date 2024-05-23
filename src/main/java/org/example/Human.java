package org.example;

/**
 * @Author: Ron
 * @Create: 2023-06-27 15:02
 */
public class Human {

    private String address;
    private String name;
    public int age;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human() {
    }


    private Human(String address, String name, int age) {
        this.address = address;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show() {
        System.out.println("你好，我是🔔");
    }

    private String showNation(String nation) {
        System.out.println("showNation！！！" + nation);
        return nation;
    }

}
