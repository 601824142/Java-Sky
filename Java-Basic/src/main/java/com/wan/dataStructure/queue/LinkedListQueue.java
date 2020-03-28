package com.wan.dataStructure.queue;


import com.wan.dataStructure.construct.LinkedList;

/**
 * @项目名称：JAVA
 * @类名称：LinkedListQueue
 * @类描述：链表队列
 * @创建人：万星明
 * @创建时间：2020/3/25
 */
public class LinkedListQueue<E> implements Queue<E>
{

    /**
     * 初始化链表
     */
    LinkedList<E> list;

    /**
     * 初始化链表空队列
     */
    public LinkedListQueue() {
        list = new LinkedList<>();
    }


    /**
     * 获取队列的大小
     */
    @Override
    public int getSize() {
        return list.getSize();
    }


    /**
     * 查看队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    /**
     * 将一个元素插入队尾
     */
    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }


    /**
     * 将队首一个元素移除队列
     */
    @Override
    public E dequeue() {
        return list.removeFirst();
    }


    /**
     * 获取队首的一个元素
     */
    @Override
    public E getFront() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        return String.format( "队列大小: %d \n",list.getSize() ) +
                "front [" +
                list +
                "] tail";
    }

}
