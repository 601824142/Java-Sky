package com.wan.dataTypeAndReferences.stringAnalysis;

import java.io.UnsupportedEncodingException;

/**
 * @项目名称：Java-Sky
 * @类名称：StringDemo
 * @类描述：字符串
 * @创建人：万星明
 * @创建时间：2020/3/28
 */
public class StringDemo
{

    public static void main(String[] args) {
        internTest();
    }


    /**字符数组构建字符串*/
    private static String newString()
    {
        //String 类是不可改变的。所以你一旦创建了String对象,那它的值就无法改变了
        char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
        return  new String(helloArray);
    }

    private static void subCharAt()
    {
        String str = "晚来天欲雪 能饮一杯无";
        //字符串的雪字打印输出  charAt(int index)
        System.out.println("字符串的长度是："+str.length());
        //取出子串  雪
        System.out.println(str.charAt(4));
        //取出从index2开始直到最后的子串，包含2
        System.out.println(str.substring(2));
        //取出index从2到4的子串，包含2不包含4  顾头不顾尾
        System.out.println(str.substring(2,4));
    }

    /**字符串索引*/
    private static void indexString()
    {
        String str = "赵客缦胡缨 吴钩胡缨霜雪明";

        //查找胡在字符串中第一次出现的位置
        System.out.println("\"胡\"在字符串中第一次出现的位置："+str.indexOf("胡"));
        //查找子串"胡缨"在字符串中第一次出现的位置
        System.out.println("\"胡缨\"在字符串中第一次出现的位置"+str.indexOf("胡缨"));
        //查找胡在字符串中最后一次次出现的位置
        System.out.println(str.lastIndexOf("胡"));
        //查找子串"胡缨"在字符串中最后一次出现的位置
        System.out.println(str.lastIndexOf("胡缨"));
        //从indexof为5的位置，找第一次出现的"胡"
        System.out.println(str.indexOf("胡",5));
    }

    /**字符串转Byte数组*/
    private static void stringToByteArray()
    {
        try {
            String str = "hhhabc银鞍照白马 飒沓如流星";
            //将字符串转换为byte数组，并打印输出
            byte[] arrs = str.getBytes("GBK");
            for(int i=0;i<arrs.length;i++) {
                System.out.print(arrs[i]);
            }
            //将byte数组转换成字符串
            String str1 = new String(arrs,"GBK");
            //保持字符集的一致，否则会出现乱码
            System.out.println(str1);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**equals与==*/
    private static void equalsTest()
    {
        String str1 = "mpp";
        String str2 = "mpp";
        String str3 = new String("mpp");

        //true  内容相同
        System.out.println(str1.equals(str2));
        //true  内容相同
        System.out.println(str1.equals(str3));
        //true   地址相同
        System.out.println(str1==str2);
        //false  地址不同
        System.out.println(str1==str3);
    }


    /**字符串连接*/
    private static void contactTest()
    {
        //1连接方式
        String s1 = "a";
        String s2 = "a";
        String s3 = "a" + s2;
        String s4 = "a" + "a";
        String s5 = s1 + s2;
        //表达式有变量时，运行期才计算，所以地址不一样
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        //表达式只有常量时，编译期完成计算
        System.out.println(s4 == "aa");
    }


    /**字符串Intern将字符串加入常量池并返回常量的引用*/
    private static void internTest()
    {
        String s1 = "a";
        String s2 = new String("a");
        //调用intern时,如果s2中的字符不在常量池，则加入常量池并返回常量的引用
        String s3 = s2.intern();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }


}
