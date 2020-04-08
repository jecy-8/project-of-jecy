package jecy.test.traps;

import java.util.Arrays;
import java.util.List;

public class BasicTypeArrays2List {

    public static void main(String[] args) {

        int[] data = {1, 2, 3, 4, 5};
        // 基本类型不能被泛型化，传入asList中作为参数时把int类型数组作为T的类型
//        Integer[] data = {1, 2, 3, 4, 5};
        List list = Arrays.asList(data);
        System.out.println("list size is " + list.size());
        System.out.println("element type is " + list.get(0).getClass());
        System.out.println(data.equals(list.get(0)));

    }
}
