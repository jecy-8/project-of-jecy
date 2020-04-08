package jecy.test.lightspots;

public class bitmove {

    public static void main(String[] args) {
        int a = 2;
        System.out.println(2 << 2);
        System.out.println(2 << 3);

        int b = 30;
        System.out.println(b >> 1);
        System.out.println(b >> 2);
        // 如果右操作数大于左操作数的位数,系统会做如下处理:
        // 如果左操作数为int，先将70%32，得到k, 再将该数向相应方向移动k位
        // 如果左操作数为long, 将上面的32改成64
        System.out.println(b >> 68);


        long c = 30;
        System.out.println(c >> 2);
        System.out.println(c >> 68);

    }
}
