package org.example.demo;

import java.io.*;

/**
 * @Author: Ron
 * @Create: 2023-11-10 17:05
 */
public class DeepCopyTest {
    public static void main(String[] args) throws Exception {
        Address address = new Address("Beijing");
        Person person1 = new Person("Tom", address);
        Person person2 = (Person) deepCopy(person1);
        System.out.println(person1 == person2); // false
        System.out.println(person1.getAddress() == person2.getAddress()); // false
    }
    private static Object deepCopy(Object obj) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

}

class Person implements Serializable {
    private String name;
    private Address address;
    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }
}
class Address implements Serializable {
    private String city;
    public Address(String city) {
        this.city = city;
    }
}