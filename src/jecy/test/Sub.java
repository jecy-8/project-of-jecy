package jecy.test;

public class Sub extends Parent {

    static {
        i = 0;
    }
    private static int i = 1;


    public static void main(String[] args) {
        System.out.println(i);
    }
}
