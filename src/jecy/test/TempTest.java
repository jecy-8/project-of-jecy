package jecy.test;

import java.util.ArrayList;
import java.util.Arrays;

public class TempTest {
    public static void printArray(String[] array) {
        for(int i = 0; i < array.length; i ++)
        {
            System.out.println("Hello World!");
        }
    }
    public static void main(String[] args) {
        String[] array = {"1", "2", "3"};
        printArray(array);

        String sb = new StringBuffer("Test").append("aaa").toString();
        System.out.println(sb.intern() == sb);

        System.out.println(new ArrayList<Integer>().getClass() == new ArrayList<String>().getClass());

        int i = Arrays.binarySearch(new int[]{1, 2, 3}, 3);
        int j = Arrays.binarySearch(new String[]{"1", "2", "3"}, "3");
        System.out.println(i + "\n" + j);


    }
}
