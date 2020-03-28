package com.wan.dataStructure.stack;


import com.wan.dataStructure.construct.Array;

/**
 * @项目名称：JAVA
 * @类名称：ArrayStack
 * @类描述：动态数组堆栈
 * @创建人：万星明
 * @创建时间：2020/3/23
 */
public class ArrayStack<E> implements Stack<E>
{

    /**
     * 初始空数组
     */
    Array<E> array;


    /**
     * 初始化方法,初始容量
     * @param capacity 容量
     */
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * 初始化无容量数组
     */
    public ArrayStack(){
        array = new Array<>();
    }


    /**
     * 获取数组大小
     * @return 数组大小
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断数组是否为空
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取数组容量
     * @return 数组容量
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 向堆栈中添加一个元素,在数组最后
     * @param e 元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 从堆栈中取出最后一个元素
     * @return 元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查询堆栈中最后一个元素
     * @return 最后一个元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("堆栈大小: %d , 容量: %d\n",array.getSize(),array.getCapacity()));
        result.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if(i != array.getSize() - 1){
                result.append(", ");
            }
        }
        result.append("] top");
        return result.toString();
    }

}
