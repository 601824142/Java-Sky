package com.wan.datastructure.stack;

/**
 * @项目名称：JAVA
 * @类名称：Stack
 * @类描述：堆栈接口
 * @创建人：万星明
 * @创建时间：2020/3/23
 */
public interface Stack<E>
{

    /**
     * 获取栈的大小
     */
    int getSize();

    /**
     * 判断栈是否为空
     */
    boolean isEmpty();

    /**
     * 向栈中插入一个元素
     */
    void push(E e);

    /**
     * 向栈中移除一个元素
     */
    E pop();

    /**
     * 查看栈顶元素
     */
    E peek();

}
