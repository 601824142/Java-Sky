package com.wan.dataTypeAndReferences.basicDataReference;

import java.lang.annotation.Native;
/**
 * @项目名称：Java-Sky
 * @类名称：Integer
 * @类描述：Integer源码分析
 * @创建人：万星明
 * @创建时间：2020/3/28
 */
public final class Integer {

    /**最大值*/
    @Native
    public static final int   MAX_VALUE = 0x7fffffff;
    /**最小值*/
    @Native
    public static final int   MIN_VALUE = 0x80000000;

    @Native
    public static final int SIZE = 32;


    private final int value;

    public Integer(int value) {
        this.value = value;
    }

    public Integer(String s) throws NumberFormatException {
        this.value = parseInt(s, 10);
    }

    public int intValue() {
        return value;
    }


    /**容量大小表*/
    final static int [] sizeTable = {9,99,999,9999,99999,999999,9999999,
                                     99999999,999999999,Integer.MAX_VALUE };

    /*使用包装类的TYPE属性来获取包装类对应的Class类,其中的getPrimitiveClass方法不是公共方法*/
//    @SuppressWarnings("unchecked")
//    public static final Class<Integer>  TYPE = (Class<Integer>) Class.getPrimitiveClass("int");

    /**用于将数字表示为字符串的所有可能字符*/
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    /**100个数的十位数值*/
    final static char [] DigitTens = {
            '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
            '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
            '2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
            '3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
            '4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
            '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
            '6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
            '7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
            '8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
            '9', '9', '9', '9', '9', '9', '9', '9', '9', '9',
            } ;

    /**100个数的个位数值*/
    final static char [] DigitOnes = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            } ;

    /**
     * Integer常量缓存内部类
     */
    private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        private IntegerCache() {}
        static {
            //最大值可以根据JVM的属性动态配置IntegerCache.high
            int h = 127;
            String integerCacheHighPropValue = sun.misc.VM.getSavedProperty("Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    //返回两个最大的
                    i = Math.max(i, 127);
                    //最大不能超过MAX_VALUE+127
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    //如果属性不能转成int,忽略掉
                }
            }
            high = h;
            //Integer缓存常量数组长度等于low+high+1
            cache = new Integer[(high - low) + 1];
            int j = low;
            //循环赋值
            for(int k = 0; k < cache.length; k++) {
                cache[k] = new Integer(j++);
            }
            //断言上限肯定大于等于127
            assert Integer.IntegerCache.high >= 127;
        }
    }


    /**私有方法*/
    static int stringSize(int x) {
        for (int i=0; ; i++) {
            if (x <= sizeTable[i]) {
                return i+1;
            }
        }
    }

    /**int转字符串*/
    public static String toString(int i) {
        if (i == Integer.MIN_VALUE) {
            return "-2147483648";
        }
        int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
        char[] buf = new char[size];
        getChars(i, size, buf);
        return new String(buf);
//        return new String(buf,true);
    }

    public static String toString(int i, int radix) {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            radix = 10;
        }

        /* Use the faster version */
        if (radix == 10) {
            return toString(i);
        }

        char buf[] = new char[33];
        boolean negative = (i < 0);
        int charPos = 32;

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = digits[-(i % radix)];
            i = i / radix;
        }
        buf[charPos] = digits[-i];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }

    static void getChars(int i, int index, char[] buf) {
        int q, r;
        int charPos = index;
        char sign = 0;

        if (i < 0) {
            sign = '-';
            i = -i;
        }

        // Generate two digits per iteration
        while (i >= 65536) {
            q = i / 100;
            // really: r = i - (q * 100);
            r = i - ((q << 6) + (q << 5) + (q << 2));
            i = q;
            buf [--charPos] = DigitOnes[r];
            buf [--charPos] = DigitTens[r];
        }

        // Fall thru to fast mode for smaller numbers
        // assert(i <= 65536, i);
        for (;;) {
            q = (i * 52429) >>> (16+3);
            r = i - ((q << 3) + (q << 1));
            buf [--charPos] = digits [r];
            i = q;
            if (i == 0) {
                break;
            }
        }
        if (sign != 0) {
            buf [--charPos] = sign;
        }
    }

    public static int parseInt(String s) throws NumberFormatException {
        return parseInt(s,10);
    }

    public static int parseInt(String s, int radix)
    throws NumberFormatException
    {
        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +" less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +" greater than Character.MAX_RADIX");
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    //throw NumberFormatException.forInputString(s);

                {
                    if (len == 1) {
    //                    throw NumberFormatException.forInputString(s);
                    }
                }
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
//                    throw NumberFormatException.forInputString(s);
                }
                if (result < multmin) {
//                    throw NumberFormatException.forInputString(s);
                }
                result *= radix;
                if (result < limit + digit) {
//                    throw NumberFormatException.forInputString(s);
                }
                result -= digit;
            }
        } else {
//            throw NumberFormatException.forInputString(s);
        }
        return negative ? result : -result;
    }

    public static Integer valueOf(int i) {
        if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high) {
            return IntegerCache.cache[i + (-IntegerCache.low)];
        }
        return new Integer(i);
    }

    public static Integer valueOf(String s,int radix) throws NumberFormatException {
        return Integer.valueOf(parseInt(s,radix));
    }

    public static Integer valueOf(String s) throws NumberFormatException {
        return Integer.valueOf(parseInt(s, 10));
    }


    public static long toUnsignedLong(int x) {
        return ((long) x) & 0xffffffffL;
    }

    public static String toUnsignedString(int i) {
        return Long.toString(toUnsignedLong(i));
    }

    public static String toUnsignedString(int i, int radix) {
        return Long.toUnsignedString(toUnsignedLong(i), radix);
    }

    public static String toHexString(int i) {
        return toUnsignedString0(i, 4);
    }

    public static String toOctalString(int i) {
        return toUnsignedString0(i, 3);
    }

    public static String toBinaryString(int i) {
        return toUnsignedString0(i, 1);
    }

    private static String toUnsignedString0(int val, int shift) {
        // assert shift > 0 && shift <=5 : "Illegal shift value";
        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
        char[] buf = new char[chars];

        formatUnsignedInt(val, shift, buf, 0, chars);

        // Use special constructor which takes over "buf".
        return new String(buf);
//        return new String(buf, true);
    }

    public static int parseUnsignedInt(String s) throws NumberFormatException {
        return parseUnsignedInt(s, 10);
    }

    public static int parseUnsignedInt(String s, int radix) throws NumberFormatException {
        if (s == null)  {
            throw new NumberFormatException("null");
        }

        int len = s.length();
        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar == '-') {
                throw new NumberFormatException(String.format("Illegal leading minus sign " + "on unsigned string %s.", s));
            } else {
                // Integer.MAX_VALUE in Character.MAX_RADIX is 6 digits
                if (len <= 5 || (radix == 10 && len <= 9) ) { // Integer.MAX_VALUE in base 10 is 10 digits
                    return parseInt(s, radix);
                } else {
                    long ell = Long.parseLong(s, radix);
                    if ((ell & 0xffff_ffff_0000_0000L) == 0) {
                        return (int) ell;
                    } else {
                        throw new NumberFormatException(String.format("String value %s exceeds " + "range of unsigned int.", s));
                    }
                }
            }
        } else {
            throw new NumberFormatException(String.format("字符串 %s 输入异常", s));
//            throw NumberFormatException.forInputString(s);
        }
    }

    static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
        int charPos = len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[offset + --charPos] = Integer.digits[val & mask];
            val >>>= shift;
        } while (val != 0 && charPos > 0);

        return charPos;
    }

    public static int numberOfLeadingZeros(int i) {
        // HD, Figure 5-6
        if (i == 0) {
            return 32;
        }
        int n = 1;
        if (i >>> 16 == 0) { n += 16; i <<= 16; }
        if (i >>> 24 == 0) { n +=  8; i <<=  8; }
        if (i >>> 28 == 0) { n +=  4; i <<=  4; }
        if (i >>> 30 == 0) { n +=  2; i <<=  2; }
        n -= i >>> 31;
        return n;
    }

    public static int numberOfTrailingZeros(int i) {
        // HD, Figure 5-14
        int y;
        if (i == 0) {
            return 32;
        }
        int n = 31;
        y = i <<16; if (y != 0) { n = n -16; i = y; }
        y = i << 8; if (y != 0) { n = n - 8; i = y; }
        y = i << 4; if (y != 0) { n = n - 4; i = y; }
        y = i << 2; if (y != 0) { n = n - 2; i = y; }
        return n - ((i << 1) >>> 31);
    }


    public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }


    public static Integer decode(String nm) throws NumberFormatException {
        int radix = 10;
        int index = 0;
        boolean negative = false;
        Integer result;

        if (nm.length() == 0)
            throw new NumberFormatException("Zero length string");
        char firstChar = nm.charAt(0);
        // Handle sign, if present
        if (firstChar == '-') {
            negative = true;
            index++;
        } else if (firstChar == '+')
            index++;

        // Handle radix specifier, if present
        if (nm.startsWith("0x", index) || nm.startsWith("0X", index)) {
            index += 2;
            radix = 16;
        }
        else if (nm.startsWith("#", index)) {
            index ++;
            radix = 16;
        }
        else if (nm.startsWith("0", index) && nm.length() > 1 + index) {
            index ++;
            radix = 8;
        }

        if (nm.startsWith("-", index) || nm.startsWith("+", index))
            throw new NumberFormatException("Sign character in wrong position");

        try {
            result = Integer.valueOf(nm.substring(index), radix);
            result = negative ? Integer.valueOf(-result.intValue()) : result;
        } catch (NumberFormatException e) {
            String constant = negative ? ("-" + nm.substring(index)) : nm.substring(index);
            result = Integer.valueOf(constant, radix);
        }
        return result;
    }

}
