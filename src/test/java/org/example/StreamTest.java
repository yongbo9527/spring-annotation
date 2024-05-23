package org.example;

import org.junit.Test;

/**
 * @Author: Ron
 * @Create: 2023-06-14 16:50
 */
public class StreamTest {

    @Test
    public void test(){
        int[] ints = new int[10];
//        List<Integer> eachDataList = Arrays.stream(ints).boxed().collect(Collectors.toList());

        int[] ints1 = new int[]{1,2,3,4,5,6,7,8,9,10};

        String[] str = {"1","2","3","4","5","6","7","8","9","10"};

        String[] str1;
        str1 = new String[] {"1","2"};

        //静态初始化
        int[][] arr1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //动态初始化1
        String[][] arr2 = new String[3][2];
        //2.如何调用数组的指定位置的元素
        System.out.println(arr1[0][1]);	//2
        System.out.println(arr2[1][1]);	//null

        System.out.println();
    }

    @Test
    public void test01(){
        String[] str = new String[3];
        System.out.println(str);
    }

}
