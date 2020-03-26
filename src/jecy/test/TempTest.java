package jecy.test;

public class TempTest {
    public static void printArray(String[] array) {
        for(int i = 0; i <= array.length; i ++)
        {
            System.out.println("Hello World!");
        }
    }
    public static void main(String[] args) {
        String[] array = {"1", "2", "3"};
        printArray(array);
    }
}
