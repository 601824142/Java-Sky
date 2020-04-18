package com.wan.java8;

/**
 * @项目名称：Java-Sky
 * @类名称：
 * @类描述：
 * @创建人：万星明
 * @创建时间：2020/4/18
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
