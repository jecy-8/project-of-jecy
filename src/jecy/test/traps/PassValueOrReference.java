package jecy.test.traps;

public class PassValueOrReference {

    public static void main(String[] args) {

        /*
        由基本数据类型封装得来的类都是final，像String ,Long ,Integer... 所以他们的引用对象是不可以改变的，但是可以改变值，
        但是String,Long,Integer等类并没有提供内部方法来修改 引用所“指向”的值，而对于+或++等操作都是把结果重新放进一个new对象里，
        所以在test方法中Integer会重新new一个对象来存放结果 而对于StringBuffer来说，append()方法则是StringBuffer类的方法，
        专门用来修改内部值的，所以调用append时 引用不会变，但是，引用所指向的值变了，所以就达到了“传引用”的效果
         */

        Integer a = 5;
        System.out.println("Primary Integer: " + a);
        System.out.println("Test Integer: " + testPassInteger(a));
        System.out.println("After test Integer: " + a);


        StringBuffer sb = new StringBuffer("abc");
        System.out.println("Primary StringBuffer: " + sb);
        System.out.println("Test StringBuffer: " + testPassStringBuffer(sb));
        System.out.println("After test StringBuffer: " + sb);
    }

    private static StringBuffer testPassStringBuffer(StringBuffer sb) {
        sb.append("s");
        return sb;
    }

    private static Integer testPassInteger(Integer i) {
        i ++;
        return i;
    }
}
