package com.wan.dataTypeAndReferences.staticAndFinal;

/**
 * @项目名称：Java-Sky
 * @类名称：
 * @类描述：
 * @创建人：万星明
 * @创建时间：2020/3/28
 */
public class FinalTest {

      String a;

    public FinalTest(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "FinalTest{" +
                "a='" + a + '\'' +
                '}';
    }

    static void test()
    {
        //对于基本类型，final 使数值不变
        final int a=1;
        //对于引用类型，final 使引用不变，也就不能引用其它对象，但是被引用的对象本身是可以修改的
        final FinalTest finalTest = new FinalTest("1");
        finalTest.setA("2");
        System.out.println(finalTest);
    }

    public static void main(String[] args) {
        test();
    }


}
