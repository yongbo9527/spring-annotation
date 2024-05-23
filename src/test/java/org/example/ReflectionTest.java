package org.example;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @Author: Ron
 * @Create: 2023-06-27 14:58
 */
public class ReflectionTest {
    @Test
    public void test() {
        //1.创建类的对象
//        Human p1 = new Human("jay", 21);
//
//        //2.调用对象,调用其内部的属性和方法
//        p1.age = 15;
//        System.out.println(p1.toString());
//
//        p1.show();

        //在Person类的外部，不可以通过Person类的对象调用其内部私有的结构。
        //比如：name、showNation以及私有的构造器。
    }

    @Test
    public void test01() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        Class clazz = Human.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Jon", 18);
        Human p = (Human) obj;
        System.out.println(p.toString());
        //2.通过反射，调用对象指定的属性和方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
    }


    @Test
    public void test02() throws Exception {
        Class clazz = Human.class;

        //通过反射，是可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons2 = clazz.getDeclaredConstructor(String.class);
        cons2.setAccessible(true);
        Human p1 = (Human) cons2.newInstance("kalo");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Taoyao");
        System.out.println(p1);

//        Method getName = clazz.getDeclaredMethod("getName");
//        System.out.println(getName.invoke(p1));
        String invoke = (String) clazz.getMethod("getName").invoke(p1);
        System.out.println(invoke);

        // 获取属性
        clazz.getFields();


        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"FaceBook");
        //相当于String nation = p1.showNation("FaceBook")
        System.out.println(nation);
    }

    @Test
    public void test03() {
        Class clazz = Human.class;
        System.out.println("getMethods===================================");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("getDeclaredMethods===================================");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("getFields===================================");
        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("getDeclaredFields===================================");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("getConstructors===================================");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("getDeclaredConstructors===================================");
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("getAnnotatedInterfaces===================================");
        AnnotatedType[] annotatedInterfaces = clazz.getAnnotatedInterfaces();
        for (AnnotatedType annotatedInterface : annotatedInterfaces) {
            System.out.println(annotatedInterface);
        }
        System.out.println("getAnnotations===================================");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
