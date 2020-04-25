package com.wan.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @项目名称：Java-Sky
 * @类名称：HeapOOM
 * @类描述：堆内存溢出异常测试
 * @创建人：万星明
 * @创建时间：2020/4/25
 */
public class HeapOOM
{

    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> objects = new ArrayList<>();
        while (true)
        {
            objects.add(new OOMObject());
        }
    }

}
