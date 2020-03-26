package com.wan.datastructure.stack;

import com.wan.datastructure.LinkedList;

/**
 * @项目名称：JAVA
 * @类名称：
 * @类描述：
 * @创建人：万星明
 * @创建时间：2020/3/23
 */
public class LinkedListStack<E> implements Stack<E>
{

    private LinkedList<E> list;

    public LinkedListStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("堆栈大小为:%d \n", list.getSize()));
        result.append("top");
        result.append(list);
        return result.toString();
    }
}
