package com.wan.dataStructure.queue;

/**
 * @项目名称：JAVA
 * @类名称：Queue
 * @类描述：队列
 * @创建人：万星明
 * @创建时间：2020/3/24
 */
public interface Queue<E>
{

    /**
     * 获取队列的大小
     */
    int getSize();

    /**
     * 查看队列是否为空
     */
    boolean isEmpty();

    /**
     * 将一个元素插入队尾
     */
    void enqueue(E e);

    /**
     * 将队首一个元素移除队列
     */
    E dequeue();

    /**
     * 获取队首的一个元素
     */
    E getFront();

}
