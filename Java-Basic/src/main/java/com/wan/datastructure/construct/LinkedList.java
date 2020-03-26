package com.wan.datastructure.construct;

/**
 * @项目名称：JAVA
 * @类名称：LinkedList
 * @类描述：链表(头指针、虚拟节点)
 * @创建人：万星明
 * @创建时间：2020/3/23
 */
public class LinkedList<E>
{

    /**虚拟头节点*/
    private Node dummyHead;
    /**链表大小*/
    private int size;

    /**
     * 私有内部类(节点)
     */
    private class Node{
        //元素
        private E e;
        //节点
        private Node next;

        public Node() {
            this(null,null);
        }

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    /**
     * 初始化节点,大小
     */
    public LinkedList() {
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取大小
     * @return 大小
     */
    public int getSize(){
        return size;
    }

    /**
     * 是否为空
     * @return 是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 向链表指定位置添加元素
     * @param index 索引下标
     * @param e 元素
     */
    public void add(int index, E e){
        //如果下标索引不足
        if(index < 0 || index > size){
            throw new IllegalArgumentException("添加失败,索引下标异常");
        }
        //头部节点设置为前缀节点
        Node prev = dummyHead;
        //将索引前的,节点重置
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //创造新节点指向
        prev.next = new Node(e,prev.next);
        size ++;
    }


    /**
     * 向链表头添加元素
     */
    public void addFirst(E e){
        add(0,e);
    }


    /**
     * 向链表尾部添加元素
     */
    public void addLast(E e){
        add(size,e);
    }


    /**
     * 获取指定位置元素
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("获取元素失败,索引下标越界");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }


    /**
     * 获取链表头部的元素
     */
    public E getFirst(){
        return get(0);
    }


    /**
     * 获取链表尾部的元素
     */
    public E getLast(){
        return get(size);
    }


    /**
     * 修改指定位置的元素
     */
    public void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("修改指定元素失败,索引不存在");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }


    /**
     * 判断链表是否包含某个元素
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    /**
     * 删除指定位置的元素
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("删除失败,索引下标越界");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode.e;
    }


    /**
     * 删除指定元素
     */
    public void remove(E e){
        if(!contains(e)){
            throw new IllegalArgumentException("删除失败,元素不存在");
        }
        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }


    /**
     * 删除所有的指定元素
     */
    public void removeAll(E e){
        if(!contains(e)){
            throw new IllegalArgumentException("删除失败,元素不存在");
        }
        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next.e.equals(e)){
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                size --;
                continue;
            }
            prev = prev.next;
        }
    }


    /**
     * 删除链表头部的元素
     */
    public E removeFirst(){
        return remove(0);
    }


    /**
     * 删除链表尾部的元素
     */
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("LinkedList大小: %d\n",size));
        result.append("head ");
        Node cur = dummyHead.next;
        while (cur != null){
            result.append(cur+ "->");
            cur = cur.next;
        }
        result.append("NULL");
        return result.toString();
    }

}
