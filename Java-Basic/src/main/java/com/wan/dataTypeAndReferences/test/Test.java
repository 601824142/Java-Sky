package com.wan.dataTypeAndReferences.test;

import java.util.Scanner;

/**
 * @项目名称：Java-Sky
 * @类名称：
 * @类描述：
 * @创建人：万星明
 * @创建时间：2020/3/29
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String str3 = sc.next();

        int[] price = transform(str1);
        int[] weight = transform(str2);
        int[] bag = transform(str3);

        sc.close();

        int backpack = bag[0];
        int num = price.length;

        int[][] capacity = getArrays( backpack,num,weight,price );
        System.out.println(capacity[capacity.length-1][capacity[0].length-1]);
    }

    static int[][] getArrays(int backpack, int num, int[] weight, int[] price)
    {
        //初始化矩阵
        int[][] capacity = new int[num + 1][backpack + 1];
        //初始值都为0
        for (int i = 0; i < num + 1; i++) {
            capacity[i][0] = 0;
        }
        for (int j = 0; j < backpack + 1; j++) {
            capacity[0][j] = 0;
        }


        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < backpack + 1; j++) {
                //当i物品重量小于j时
                if (weight[i - 1] <= j) {
                    //如果本物品放入包中
                    if (capacity[i - 1][j] < (capacity[i - 1][j - weight[i - 1]] + price[i - 1])) {
                        capacity[i][j] = capacity[i - 1][j - weight[i - 1]] + price[i - 1];
                    }
                    //不放入包中
                    else {
                        capacity[i][j] = capacity[i - 1][j];
                    }
                //i物品重量大于j
                } else {
                    capacity[i][j] = capacity[i - 1][j];
                }
            }
        }
        return capacity;
    }

    private static int[] transform(String string)
    {
        //将字符串分割
        String[] split = string.split(",");
        int[] value=new int[split.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Integer.parseInt(split[i]);
        }
        return value;
    }



}
