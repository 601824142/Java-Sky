package com.wan.datastructure.construct;


import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @项目名称：JAVA
 * @类名称：ApachTypeEnhancement
 * @类描述：类型增强
 * @创建人：万星明
 * @创建时间：2020/3/21
 */
public class ApachTypeEnhancement
{

    /**
     * 在 JDK 中，没有提供原生的 Pair 数据结构，也可以使用 Map::Entry 代替。不过，Apache 的 commons-lang3 包中的 Pair 类更为好用
     */
    public static void main(String[] args) {
        Pair<List<String>,String> pair = getPair();
        System.out.println(pair.toString());
    }

    private static Pair<List<String>, String>  getPair()
    {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        return Pair.of(arrayList,"C");
    }

}
