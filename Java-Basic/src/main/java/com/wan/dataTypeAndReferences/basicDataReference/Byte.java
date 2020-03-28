package com.wan.dataTypeAndReferences.basicDataReference;

/**
 * @项目名称：Java-Sky
 * @类名称：Byte
 * @类描述：Byte源码分析
 * @创建人：万星明
 * @创建时间：2020/3/28
 */


public final class Byte
{
    //最大值
    public static final byte   MAX_VALUE = 127;
    //最小值
    public static final byte   MIN_VALUE = -128;

    public static final int SIZE = 8;

    /**
     * 值
     */
    private final byte value;

    /**
     * 构造方法
     * @param value 值
     */
    public Byte(byte value) {
        this.value = value;
    }

    /**
     * 构造方法(传字符串,默认十进制)
     * @param s 字符串
     * @throws NumberFormatException 越界=>类型转换异常
     */
    public Byte(String s) throws NumberFormatException {
        this.value = parseByte(s, 10);
    }

    /*使用包装类的TYPE属性来获取包装类对应的Class类,其中的getPrimitiveClass方法不是公共方法*/
//    @SuppressWarnings("unchecked")
//    public static final Class<Byte> TYPE = (Class<Byte>) Class.getPrimitiveClass("byte");


    /**
     * 将Byte数转化为10进制字符串
     * @param b Byte
     * @return 10进制字符串
     */
    public static String toString(byte b) {
        return Integer.toString((int)b, 10);
    }


    /**
     * Byte类型的静态内部类常量缓存
     */
    private static class ByteCache {
        private ByteCache(){}
        //静态常量引用类型数组长度256
        static final Byte cache[] = new Byte[-(-128) + 127 + 1];
        //静态代码块FOR循环设置指定索引的数组值
        static {
            for(int i = 0; i < cache.length; i++) {
                cache[i] = new Byte((byte)(i - 128));
            }
        }
    }

    /**
     * 将byte数据转引用类型
     * @param b byte
     * @return 引用类型Byte
     */
    public static Byte valueOf(byte b) {
        final int offset = 128;
        //直接返回静态常量引用类型数组值
        return Byte.ByteCache.cache[(int)b + offset];
    }


    /**
     * 将字符串转为指定进制byte
     * @param s 字符串
     * @param radix 进制
     * @return byte数值
     * @throws NumberFormatException 越界=>类型转换异常
     */
    public static byte parseByte(String s, int radix) throws NumberFormatException {
        int i = Integer.parseInt(s, radix);
        //越界=>类型转换异常
        if (i < MIN_VALUE || i > MAX_VALUE) {
            throw new NumberFormatException(
                    "Value out of range. Value:\"" + s + "\" Radix:" + radix);
        }
        return (byte)i;
    }

    /**
     * 将字符串转为10进制byte
     * @param s 字符串
     * @return byte数值
     * @throws NumberFormatException 越界=>类型转换异常
     */
    public static byte parseByte(String s) throws NumberFormatException {
        return parseByte(s, 10);
    }

    /**
     * 将字符串转为指定进制Byte
     * @param s 字符串
     * @param radix 进制
     * @return Byte引用值
     * @throws NumberFormatException 越界=>类型转换异常
     */
    public static Byte valueOf(String s,int radix) throws NumberFormatException {
        return valueOf(parseByte(s, radix));
    }

    /**
     * 将字符串转为指定进制Byte
     * @param s 字符串
     * @return Byte引用值
     * @throws NumberFormatException 越界=>类型转换异常
     */
    public static Byte valueOf(String s) throws NumberFormatException {
        return valueOf(s, 10);
    }


    /**
     * 将字符串转为指定进制Byte(在字符串非十进制时使用)
     * @param nm 字符串
     * @return Byte引用值
     * @throws NumberFormatException 越界=>类型转换异常
     */
    public static Byte decode(String nm) throws NumberFormatException {
        int i = Integer.decode(nm).intValue();
        //越界=>类型转换异常
        if (i < MIN_VALUE || i > MAX_VALUE) {
            throw new NumberFormatException("Value " + i + " out of range from input " + nm);
        }
        return valueOf((byte)i);
    }

    /**
     * 获取基本类型的数值
     * @return 数值
     */
    public byte byteValue() {
        return value;
    }

    /**
     * 获取short基本类型的数值
     * @return short基本类型的数值
     */
    public short shortValue() {
        return (short)value;
    }

    /**
     * 获取int基本类型的数值
     * @return int基本类型的数值
     */
    public int intValue() {
        return (int)value;
    }

    /**
     * 获取long基本类型的数值
     * @return long基本类型的数值
     */
    public long longValue() {
        return (long)value;
    }

    /**
     * 获取float基本类型的数值
     * @return float基本类型的数值
     */
    public float floatValue() {
        return (float)value;
    }

    /**
     * 获取double基本类型的数值
     * @return double基本类型的数值
     */
    public double doubleValue() {
        return (double)value;
    }

    @Override
    public String toString() {
        return Integer.toString((int)value);
    }

    /**
     * 返回hashCode
     * @param value byte
     * @return 强转int
     */
    public static int hashCode(byte value) {
        return (int)value;
    }

    @Override
    public int hashCode() {
        return Byte.hashCode(value);
    }

    /**
     * 对比
     * @param obj 对象
     * @return 是否相同
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Byte) {
            return value == ((Byte)obj).byteValue();
        }
        return false;
    }

    /**
     * 对比
     * @param x x
     * @param y y
     * @return 运算值
     */
    public static int compare(byte x, byte y) {
        return x - y;
    }

    /**
     * 对比
     * @param anotherByte 另外一个Byte
     * @return 运算值
     */
    public int compareTo(Byte anotherByte) {
        return compare(this.value, anotherByte.value);
    }

    /**
     * 转成二进制int
     * @param x byte
     * @return 二进制int
     */
    public static int toUnsignedInt(byte x) {
        return ((int) x) & 0xff;
    }

    /**
     * 转成二进制long
     * @param x byte
     * @return 二进制long
     */
    public static long toUnsignedLong(byte x) {
        return ((long) x) & 0xffL;
    }




}
