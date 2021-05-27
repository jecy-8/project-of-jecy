package jecy.test;

public class Parent {
    public static String parentStr = "parent static string";
    static {
        System.out.println("parent static fields");
        System.out.println(parentStr);
    }

    public Parent() {
        System.out.println("parent instance initialization");
    }
}
