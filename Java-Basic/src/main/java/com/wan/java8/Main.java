package com.wan.java8;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @项目名称：Java-Sky
 * @类名称：
 * @类描述：
 * @创建人：万星明
 * @创建时间：2020/4/18
 */
public class Main {


    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));

        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);             // val33

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);     // false

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true

        map.computeIfAbsent(3, num -> "bam");
        map.get(3);             // val33

        map.remove(3, "val3");
        map.get(3);             // val33
        map.remove(3, "val33");
        map.get(3);             // null

        map.getOrDefault(42, "not found");  // not found

        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9concat
    }






    private static void testParallel() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }


        //串行排序
//        long t0 = System.nanoTime();
//        long count = values.stream().sorted().count();
//        System.out.println(count);
//
//        long t1 = System.nanoTime();
//
//        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//        System.out.println(String.format("sequential sort took: %d ms", millis));

        //并行排序
        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }


    private static void testStream() {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");

        // 测试 Filter(过滤)
//        stringList.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
//        List<String> a = stringList.stream().filter( (s) -> s.startsWith( "a" ) ).collect( Collectors.toList() );

        // 测试 Sort (排序)
//        stringList.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
//        List<String> a = stringList.stream().sorted(Comparator.reverseOrder()).filter( (s) -> s.startsWith( "a" ) ).collect( Collectors.toList() );


        // 测试 Map 操作
//        stringList.stream().map(String::hashCode).sorted(Comparator.reverseOrder()).forEach(System.out::println);


        // 测试 Match (匹配)操作
//        boolean anyStartsWithA = stringList.stream().anyMatch((s) -> s.startsWith("a"));
//        System.out.println(anyStartsWithA);
//        boolean allStartsWithA = stringList.stream().allMatch((s) -> s.startsWith("a"));
//        System.out.println(allStartsWithA);
//        boolean noneStartsWithZ = stringList.stream().noneMatch((s) -> s.startsWith("z"));
//        System.out.println(noneStartsWithZ);

        //测试 Count (计数)操作
//        long startsWithB = stringList.stream().filter((s) -> s.startsWith("b")).count();
//        System.out.println(startsWithB);

        //测试 Reduce (规约)操作
//        Optional<String> reduced = stringList.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
//        reduced.ifPresent(System.out::println);
//
//        // 字符串连接，concat = "ABCD"
//        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
//        // 求最小值，minValue = -3.0
//        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
//        // 求和，sumValue = 10, 有起始值
//        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
//        // 求和，sumValue = 10, 无起始值
//        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
//        // 过滤，字符串连接，concat = "ace"
//        concat = Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);

//        System.out.println(a);
    }


    private static void testPenson() {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }


    private static void testSomething() {
        Something something = new Something();
        Converter<String, String> converter = something :: startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
    }


    private static void testConverter() {
        //将数字字符串转换为整数类型
        Converter<String, Integer> converter = Integer :: valueOf;
        Integer converted = converter.convert("123");
        //class java.lang.Integer
        System.out.println(converted.getClass());
        System.out.println(converted);
    }

    private static void testStringCompare()
    {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>()
        {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });


        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });


        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        names.sort((a, b) -> b.compareTo(a));

        names.sort( Comparator.reverseOrder() );
    }


    static void testFormula()
    {
        // 通过匿名内部类方式访问接口
        Formula formula = new Formula()
        {
            @Override
            public double calculate(int a)
            {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }

}
