package jecy.test.genericity;

import java.util.ArrayList;
import java.util.List;

public class TestGenericity {
    public static void main(String[] args) {
        Apple apple = new Apple("apple1", "red");
        Banana banana = new Banana("banana1", "yellow");
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(apple);
        fruits.add(banana);
        testExtends(fruits);
        testSuper(fruits);
    }

    public static void testExtends(List<? extends Fruit> list) {
        //报错,extends 为上界通配符,只能取值,不能放.
//        list.add(new Apple("apple", "red", 1));
        Fruit fruit = list.get(1);
    }

    public static void testSuper(List<? super Fruit> list) {
        //super 为下界通配符， 可以存放元素， 但是也只能存放当前类或者子类的实例
        list.add(new Apple("apple", "red"));
        // 无法确定泛型是Fruit的哪个父类，因此调用获取时用Object
//        Fruit fruit = list.get(0);
        Object fruit = list.get(0);
    }

}
