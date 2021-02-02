package jecy.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

        Map<String, String> map = new HashMap<>();
        map.put("name", "Jecy");

        Class<?> type = map.getClass();
        Method capacity = type.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity=" + capacity.invoke(map));

        Field size = type.getDeclaredField("size");
        System.out.println("size=" + size.get(map));


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
