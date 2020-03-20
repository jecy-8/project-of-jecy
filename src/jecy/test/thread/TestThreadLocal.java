package jecy.test.thread;

public class TestThreadLocal {

    public static void main(String[] args) {
        new Thread("Thread1") {
            @Override
            public void run() {
                update();
            }
        }.start();

        new Thread("Thread2") {
            @Override
            public void run() {
                update();
            }
        }.start();

        new Thread("Thread3") {
            @Override
            public void run() {
                update();
            }
        }.start();
    }

    // 如果只是普通的变量，无法做到多个线程同时独立修改变量
    private static Integer initValue = 10;

    // 用ThreadLocal就可以实现多个线程同时独立修改变量
    /*private static ThreadLocal<Integer> initValue = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 10;
        }

    };*/

    private static void update() {
        initValue += 66;
        System.out.println(initValue);
        /*initValue.set(initValue.get() + 66);
        System.out.println(initValue.get());*/
    }

}
