package org.example;

import org.junit.Test;

/**
 * @Author: Ron
 * @Create: 2023-06-15 11:34
 */
public class StringTest {

    @Test
    public void test01(){
        StringBuffer sb = new StringBuffer();
        sb.append("12345678901234562");
        System.out.println(sb.capacity());
    }

    public static void main(String[] args) {
        // 整型 byte(1字节 8位) short(2字节 16位) int(4字节 32位) long(8字节 64位)
        // 浮点型 float(4字节 32位) double(8字节 64位)
        // 字符型 char(2字节 16位)
        // 布尔型 boolean

        // Java虚拟机中没有任何供boolean值专用的字节码指令，Java语言表达所操作的boolean值，
        // 在编译之后都使用java虚拟机中的int数据类型来代替：true用1表示，false用0表示。———《java虚拟机规范8版》


    }
}
