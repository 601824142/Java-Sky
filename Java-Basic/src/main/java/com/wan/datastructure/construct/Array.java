package com.wan.datastructure.construct;

/**
 * @项目名称：JAVA
 * @类名称：Array
 * @类描述：数组
 * @创建人：万星明
 * @创建时间：2020/3/22
 */
public class Array<E>
{

    /**
     * 泛型数组数据
     */
    private E[] data;

    /**
     * 数组大小
     */
    private int size;

    /**
     * 构造方法,初始化容量
     * @param capacity 容量
     */
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 初始化大小10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取大小
     * @return 大小
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取容量
     * @return 数据长度
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 是否为空
     * @return 大小是否等于0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 数组扩容
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        //新建一个新容量的数组
        E[] newData = (E[]) new Object[newCapacity];
        //循环将旧数组数据设置到新数组中
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }


    /**
     * 向指定位置添加元素
     * @param index 索引下标
     * @param e 泛型数据
     */
    public void add(int index, E e) {
        if(index < 0 || index > size)
        {
            //抛出越界异常
            throw new IllegalArgumentException("添加失败,需要索引>= 0以及索引<=size");
        }
        //如果大小等于数组长度
        if(size == data.length)
        {
            //数组动态扩容两倍
            resize(2*data.length);
        }
        //循环移动数组数据
        for (int i= size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }


    /**
     * 向头部插入泛型数据
     * @param e 泛型数据
     */
    public void addFirst(E e){
        add(0,e);
    }


    /**
     * 向尾部插入泛型数据
     * @param e 泛型数据
     */
    public void addLast(E e){
        add(size,e);
    }


    /**
     * 获取指定位置的元素
     * @param index 索引下标
     * @return 泛型元素
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("获取指定位置元素失败,索引下标不存在");
        }
        return data[index];
    }


    /**
     * 获取第一个元素
     * @return 泛型元素
     */
    public E getFirst() {
        return data[0];
    }


    /**
     * 获取最后一个元素
     * @return 泛型元素
     */
    public E getLast() {
        return get(size - 1);
    }


    /**
     * 修改设置指定索引下标元素
     * @param index 索引下标
     * @param e 泛型元素
     */
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("修改指定位置元素失败,索引下标不存在.");
        }
        data[index] = e;
    }


    /**
     * 判断数组是否包含某个元素
     * @param e 泛型元素
     * @return 是否包含
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }


    /**
     * 查询指定元素在数组中的索引下标
     * @param e 泛型元素
     * @return 索引下标
     */
    public int indexOf(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }


    /**
     * 移除取出指定索引下标的元素
     * @param index 索引下标
     * @return 移除的泛型元素
     */
    public E remove(int index)
    {
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("移除失败,索引数据不存在");
        }

        E result = data[index];
        //将该索引下标之后的元素统一,前移一位
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        //大小减一
        size--;
        //修改对象引用,垃圾回收机制回收
        data[size] = null;

        //动态缩小数组一半容量
        if(size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return result;
    }


    /**
     * 移除取出数组第一个元素
     * @return 泛型元素
     */
    public E removeFirst(){
        return remove(0);
    }


    /**
     * 移除取出数组最后一个元素
     * @return 泛型元素
     */
    public E removeLast(){
        return remove(size - 1);
    }


    /**
     * 移除数组中的某个元素
     * @param e 泛型元素
     */
    public void removeElement(E e){
        //先获取该元素索引下标
        int index = indexOf(e);
        if(index != -1){
            remove(index);
        }
    }


    /**
     * 自定义ToString
     * @return 打印字符串
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        result.append("[");
        for (int i = 0; i < size; i++){
            result.append(data[i]);
            if(i != size - 1){
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }


}
