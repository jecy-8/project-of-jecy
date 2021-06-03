package jecy.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TempTest {
    public static void printArray(String[] array) {
        for(int i = 0; i < array.length; i ++)
        {
            System.out.println("Hello World!");
        }
    }
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        /*String[] array = {"1", "2", "3"};
        printArray(array);

        String sb = new StringBuffer("Test").append("aaa").toString();
        System.out.println(sb.intern() == sb);

        System.out.println(new ArrayList<Integer>().getClass() == new ArrayList<String>().getClass());

        int i = Arrays.binarySearch(new int[]{1, 2, 3}, 3);
        int j = Arrays.binarySearch(new String[]{"1", "2", "3"}, "3");
        System.out.println(i + "\n" + j);*/

        /*Pattern pattern = Pattern.compile("Test");
        Matcher matcher = pattern.matcher("Testabc is just a Test");
        System.out.println(matcher.replaceFirst("Jecy"));*/

        /*System.out.println(f1());
        System.out.println(f2()[0]);*/

        /*Map<String, String> map = new HashMap<>();
        map.put("name", "Jecy");

        Class<?> type = map.getClass();
        Method capacity = type.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity=" + capacity.invoke(map));

        Field size = type.getDeclaredField("size");
        System.out.println("size=" + size.get(map));*/

        /*String s1 = new String("1") + new String("1");
        s1.intern();
        String s2 = "11";
        System.out.println(s1 == s2);

        String s3 = new String("11");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);*/

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("Java(TM) SE").append("Runtime Environment").toString();
        System.out.println(str2.intern() == str2);








    }

    static int f1() {
        int ret = 0;
        try {
            return ret;
        } finally {
            ret ++;
            System.out.println("f1 finally executed.");
        }
    }

    static int[] f2() {
        int[] ret = new int[]{0};
        try {
            return ret;
        } finally {
            ret[0] ++;
            System.out.println("f2 finally executed.");
        }
    }
}
