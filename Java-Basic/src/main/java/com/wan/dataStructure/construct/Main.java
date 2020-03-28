package com.wan.dataStructure.construct;


import com.wan.dataStructure.stack.ArrayStack;
import com.wan.dataStructure.stack.LinkedListStack;
import com.wan.dataStructure.stack.Stack;

import java.util.Random;

/**
 * @项目名称：JAVA
 * @类名称：
 * @类描述：
 * @创建人：万星明
 * @创建时间：2020/3/22
 */
public class Main {

    public static void main(String[] args) {
        stackTest();
    }



    /**
     * 数组测试
     */
    static  void  arrayTest()
    {
        //新建初始容量数组
        Array<Integer> array = new Array(20);
        for (int i = 0; i < 20; i++) {
            array.addLast(i);
        }

        System.out.println("初始添加的数组内容:"+array.toString());

        array.add(1,100);
        System.out.println("向索引下标为1的地方添加100:"+array.toString());
        System.out.println("索引下标为1是:"+array.get(1));


        array.set(2,200);
        System.out.println("向索引下标为2的地方修改成200:"+array.toString());
        System.out.println("索引下标为2是:"+array.get(2));

        array.remove(1);
        System.out.println("移除索引下标为1:"+array.toString());

        array.removeFirst();
        System.out.println("移除第一个:"+array.toString());

        array.removeLast();
        System.out.println("移除最后一个:"+array.toString());

        array.removeElement(8);
        System.out.println("移除元素8:"+array.toString());
    }


    static  void  stackTest()
    {
        //很明显数组堆栈比链表堆栈要快很多倍
        int count = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("数组堆栈: "+stackTest(arrayStack,count)+"秒");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("链表堆栈:"+stackTest(linkedListStack,count)+"秒");
    }


    /**
     * 堆栈测试
     * @param stack 堆栈接口类型
     * @param count 数量
     * @return 所花费的时间
     */
    private static double stackTest(Stack<Integer> stack,int count)
    {
        //获取当前的纳秒时间
        long startTime = System.nanoTime();
        Random random = new Random();
        //循环,小于count时,往堆栈中添加一个随机数
        for (int i = 0; i < count; i++) {
            int nextInt = random.nextInt(Integer.MAX_VALUE);
            stack.push(nextInt);
        }
        //循环,小于count时,去除堆栈中的数
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }



    static  void  linkedListTest()
    {
        LinkedList<Integer> list = new LinkedList<>();
        //循环添加10个元素
        for (int i=0;i<=10;i++)
        {
            list.addFirst(i);
            System.out.println(list);
        }
    }

}
