package com.wan.dataStructure.queue;


import com.wan.dataStructure.construct.Array;

/**
 * @项目名称：JAVA
 * @类名称：ArrayQueue
 * @类描述：数组队列
 * @创建人：万星明
 * @创建时间：2020/3/24
 */
public class ArrayQueue<E> implements Queue<E>
{

    /**
     * 初始化数组
     */
    private Array<E> array;

    /**
     * 初始化空队列
     */
    public ArrayQueue(){
        array = new Array<>();
    }

    /**
     * 初始化队列容量
     * @param capacity 容量
     */
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * 获取队列容量
     * @return 容量
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 获取队列的大小
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 查看队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 将一个元素插入队尾
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 将队首一个元素移除队列
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 获取队首的一个元素
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("队列大小:%d ,队列容量:%d",array.getSize(),array.getCapacity());
        result.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if(i != array.getSize() - 1){
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }

}
