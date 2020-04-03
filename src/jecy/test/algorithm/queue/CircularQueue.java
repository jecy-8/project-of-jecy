package jecy.test.algorithm.queue;

import jecy.test.algorithm.CommonUtils;

public class CircularQueue {
    /**
     * 用数组实现的循环队列
     */
    // 用于存放元素的数组
    private int[] items;
    // 队列大小
    private int size;

    // 队列中元素的个数
    private int count;

    // head表示对头下标，tail表示队尾下标
    private int head;
    private int tail;

    // 获取头元素下标
    public int getHead() {
        return head;
    }

    // 获取尾元素下标
    public int getTail() {
        return tail;
    }

    // 获取队列大小
    public int getSize() {
        return size;
    }

    // 获取数组
    public int[] getItems() {
        return items;
    }

    public CircularQueue(int capacity) {
        items = new int[capacity];
        size = capacity;
    }

    // 入队
    public boolean enQueue(int item) {
        // 判断队列是否已满
        if ((tail + 1) % size == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % size;
        return true;
    }

    // 出队
    public int deQueue() {
        // 判断队列是否为空
        if (head == tail) {
            return -1;
        }
        int tmp = items[head];
        head = (head + 1) % size;
        return tmp;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.enQueue(5);
        circularQueue.enQueue(6);
        System.out.println(CommonUtils.printCircularQueue(circularQueue));
    }

}
