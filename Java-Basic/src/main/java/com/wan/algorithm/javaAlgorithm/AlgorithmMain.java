package com.wan.algorithm.javaAlgorithm;

import java.util.Arrays;

/**
 * @项目名称：Java-Sky
 * @类名称：AlgorithmMain
 * @类描述：Java算法
* @创建人：万星明
 * @创建时间：2020/4/20
 */
public class AlgorithmMain {


    public static void main(String[] args) {

        int[] arrays = new int[] {1,3,4,2};

        insertSort(arrays);

        System.out.println( Arrays.toString( arrays ) );
    }


    /**
     * 插入排序算法
     * @param arrays
     */
    private static void insertSort(int[] arrays)
    {
        for(int i =1;i<arrays.length;i++)
        {
            //插入的数
            int num = arrays[i];

            //被插入的位置(准备和前一个数比较)
            int index = i-1;

            //如果插入的数比被插入的数小
            while(index>=0&&num<arrays[index])
            {
                //将把 arr[index] 向后移动
                arrays[index+1]=arrays[index];
                //让 index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            arrays[index+1]=num;
        }
    }


    /**
     * 冒泡排序
     * @param array 数组
     */
    public static void bubbleSort(int [] array)
    {
        //当小于排序值时
        int i,j;
        for(i=0; i<array.length; i++)
        {
            for(j=0; j<array.length-i-1; j++)
            {
                //前面的数字大于后面的数字就交换
                if(array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }



    /**
     * 二分查找
     * @param array 数组
     * @param num 查询的数
     * @return 查询数的下标
     */
    public static int biSearch(int []array,int num)
    {
        //定义起点、数组长度、中间值
        int start=0;
        int size=array.length-1;
        int middle;

        //当且仅当起点小于数组长度时
        while(start<=size)
        {
            //计算中间位置
            middle=(start+size)/2;

            //如果中间值等于查询数
            if(array[middle]==num) {
                return middle+1;
            }

            //如果中间值小于查询数,向右边查找(该数组需要为有序,从左到右依次变大)
            else if(array[middle]<num) {
                //将起点设置为中间值下标+1
                start=middle+1;
            }

            //如果中间值大于查询数,向左查询
            else {
                size=middle-1;
            }
        }
        return -1;
    }


}
