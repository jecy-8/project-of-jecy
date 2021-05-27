package jecy.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        //使用一个容器装载100个数字，通过Stream并行处理的方式将容器中为单数的数字转移到容器parallelList
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 100; i ++){
            integerList.add(i);
        }

        List<Integer> parallelList = new ArrayList<>();
//        integerList.stream().parallel().filter(i -> i%2 == 1).forEach(i -> parallelList.add(i));
        parallelList = integerList.stream().parallel().filter(i -> i%2 == 1).collect(Collectors.toList());

        for(Integer item : parallelList) {
            System.out.println(item);
        }
    }
}
