package org.example.reflect;

import org.example.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: Ron
 * @Create: 2023-11-13 14:06
 */
public class ReflectTest {

    @Test
    public void test01(){
        // 普通方法
        Person person = new Person();
        person.setName("Ron");
        person.setAge(18);
        System.out.println(person.toString());
        person.show();
    }

    @Test
    public void test02() throws Exception {
        // 反射方法
        Class<?> clazz = Class.forName("org.example.Person");
        Person person = null;
        try {
            Constructor cons = clazz.getConstructor(String.class,Integer.class);
            person = (Person) cons.newInstance("Jon",18);
            System.out.println(person.toString());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        assert person != null;
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person, 20);
        System.out.println(person.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);
    }

    @Test
    public void test03() throws Exception{
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Method show = personClass.getDeclaredMethod("show");
        Method method = personClass.getMethod("show");

//        personClass.getField("name");
        Field declaredField = personClass.getDeclaredField("name");
        declaredField.setAccessible(true);
        declaredField.set(person,"Ron");
        System.out.println(declaredField.get(person));
        System.out.println(person);
    }

    @Test
    public void test04() throws Exception {
        //方式一：
        Class<Person> c1 = Person.class;
        System.out.println(c1);

        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class<? extends Person> c2 = p1.getClass();
        System.out.println(c2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class<?> c3 = Class.forName("org.example.Person");
        // c3 = Class.forName("www.123.com");
        System.out.println(c3);

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        Class c4 = classLoader.loadClass("org.example.Person");
        System.out.println(c4);

        System.out.println(c1 == c4);
    }

}
