package jecy.test;

public class TestSynchronized {
    public synchronized void method1() {

    }

    public void method2() {
        Object o = new Object();
        synchronized (o) {

        }
    }

    public static void main(String[] args) {
        System.out.println(isPrime(14));
        System.out.println(isPrime(13));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i ++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
