package com.wan.dataTypeAndReferences.basicDataReference;

/**
 * @项目名称：Java-Sky
 * @类名称：Short
 * @类描述：Short源码分析
 * @创建人：万星明
 * @创建时间：2020/3/28
 */
public final class Short {

    //最大值
    public static final short   MAX_VALUE = 32767;
    //最小值
    public static final short   MIN_VALUE = -32768;

    public static final int SIZE = 16;

    public static final int BYTES = SIZE / java.lang.Byte.SIZE;

    private final short value;

    public Short(short value) {
        this.value = value;
    }

    public Short(String s) throws NumberFormatException {
        this.value = parseShort(s, 10);
    }

    /*使用包装类的TYPE属性来获取包装类对应的Class类,其中的getPrimitiveClass方法不是公共方法*/
//    @SuppressWarnings("unchecked")
//    public static final Class<java.lang.Short>    TYPE = (Class<java.lang.Short>) Class.getPrimitiveClass("short");

    /**
     * 将short数转化为10进制字符串
     * @param s short
     * @return 10进制字符串
     */
    public static String toString(short s) {
        return Integer.toString((int)s, 10);
    }

    /**
     * Short类型的静态内部类常量缓存
     */
    private static class ShortCache {
        private ShortCache(){}

        static final Short cache[] = new Short[-(-128) + 127 + 1];

        static {
            for(int i = 0; i < cache.length; i++) {
                cache[i] = new Short((short)(i - 128));
            }
        }
    }

    /**
     * 将字符串转为指定进制short
     * @param s 字符串
     * @param radix 进制
     * @return short数值
     * @throws NumberFormatException 越界=>类型转换异常
     */
    public static short parseShort(String s, int radix) throws NumberFormatException {
        int i = Integer.parseInt(s, radix);
        //越界=>类型转换异常
        if (i < MIN_VALUE || i > MAX_VALUE) {
            throw new NumberFormatException( "Value out of range. Value:\"" + s + "\" Radix:" + radix);
        }
        return (short)i;
    }

    /**
     * 将字符串转为指定进制short
     * @param s 字符串
     * @return short数值
     * @throws NumberFormatException 越界=>类型转换异常
     */
    public static short parseShort(String s) throws NumberFormatException {
        return parseShort(s, 10);
    }

    /**
     * 将short数据转引用类型
     * @param s short
     * @return 引用类型Short
     */
    public static Short valueOf(short s) {
        final int offset = 128;
        int sAsInt = s;
        //常量缓存
        if (sAsInt >= -128 && sAsInt <= 127) {
            return Short.ShortCache.cache[sAsInt + offset];
        }
        return new Short(s);
    }

    /**
     * 将字符串转为10进制Short
     * @param s 字符串
     * @return Short引用值
     * @throws NumberFormatException 越界=>类型转换异常
     */
    public static Short valueOf(String s) throws NumberFormatException {
        return valueOf(s, 10);
    }

    /**
     * 将字符串转为指定进制Short
     * @param s 字符串
     * @param radix 进制
     * @return Short引用值
     * @throws NumberFormatException 越界=>类型转换异常
     */
    public static Short valueOf(String s,int radix) throws NumberFormatException {
        return valueOf(parseShort(s, radix));
    }


    /**
     * 二进制按位反转
     * @param i short值
     * @return short值
     */
    public static short reverseBytes(short i) {
        return (short) (((i & 0xFF00) >> 8) | (i << 8));
    }


    /**
     * 转成二进制int
     * @param x short
     * @return 二进制int
     */
    public static int toUnsignedInt(short x) {
        return ((int) x) & 0xffff;
    }

    /**
     * 转成二进制long
     * @param x short
     * @return 二进制long
     */
    public static long toUnsignedLong(short x) {
        return ((long) x) & 0xffffL;
    }

    public byte byteValue() {
        return (byte)value;
    }

    public short shortValue() {
        return value;
    }

    public int intValue() {
        return (int)value;
    }

    public long longValue() {
        return (long)value;
    }

    public float floatValue() {
        return (float)value;
    }

    public double doubleValue() {
        return (double)value;
    }

    @Override
    public String toString() {
        return Integer.toString((int)value);
    }

    @Override
    public int hashCode() {
        return Short.hashCode(value);
    }

    public static int hashCode(short value) {
        return (int)value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Short) {
            return value == ((Short)obj).shortValue();
        }
        return false;
    }

    public int compareTo(Short anotherShort) {
        return compare(this.value, anotherShort.value);
    }

    public static int compare(short x, short y) {
        return x - y;
    }



}
