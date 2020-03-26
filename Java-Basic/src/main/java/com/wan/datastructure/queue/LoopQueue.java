package com.wan.datastructure.queue;

/**
 * @项目名称：JAVA
 * @类名称：LoopQueue
 * @类描述：循环队列
 * @创建人：万星明
 * @创建时间：2020/3/25
 */
public class LoopQueue<E> implements Queue<E>
{

    /**
     * 数组
     */
    private E[] data;

    /**
     * 前缀索引,后缀索引
     */
    private int front,tail;

    /**
     * 队列大小
     */
    private int size;

    /**
     * 初始化队列容量10
     */
    public LoopQueue(){
        this(10);
    }

    /**
     * 初始化循环队列
     * @param capacity 容量
     */
    public LoopQueue(int capacity) {
        data =(E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 获取容量
     * @return 容量
     */
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 扩容
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 将一个元素插入队尾
     */
    @Override
    public void enqueue(E e) {
        //判断队列容量是否已满
        if((tail + 1) % data.length == front){
            //扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }


    /**
     * 将队首一个元素移除队列
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空,无法移除取出");
        }
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            //缩容
            resize(getCapacity() / 2);
        }
        return result;
    }


    /**
     * 获取队首的一个元素
     */
    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("队列大小: %d ,容量: %d\n",size,data.length));
        result.append("front [");
        for (int i = front; i != tail; i = (i+1) % data.length){
            result.append(data[i]);
            if((i+1) % data.length != tail){
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }

}
