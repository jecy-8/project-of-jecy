package jecy.test.algorithm.queue;

import jecy.test.algorithm.CommonUtils;

public class ArrayQueue {
    /**
     * 用数组实现的队列
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

    // 申请一个大小为capacity的队列
    public ArrayQueue(int capacity) {
        items = new int[capacity];
        size = capacity;
    }

    // 获取队列大小
    public int getSize() {
        return size;
    }

    // 获取队列中元素的个数
    public int getCount() {
        return count;
    }

    // 获取队列头元素下标
    public int getHead() {
        return head;
    }

    // 获取队列尾元素下标
    public int getTail() {
        return tail;
    }

    // 获取数组
    public int[] getItems() {
        return items;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return head == tail ? true : false;
    }

    // 判断队列是否已满
    public boolean isFull() {
        if (tail == size) {
            // 整个队列被占满
            if (head == 0) {
                return true;
            }
            // 当count=size时head<>0表示前面有出栈操作，head指针往后移，前面有空间，可以进行数据搬移
            for (int i = head; i < tail; i ++) {
                items[i - head] = items[i];
            }
            System.out.println("The queue has been reorganized by moving " + head+ " step" + (head > 1 ? "s" : "") + " to the head.");
            // 搬移完后更新head和tail指针，注意以下两步不能顺序不能调换
            tail -= head;
            head = 0;
            return false;
        }
        return false;
    }

    // 入队（队尾入）
    public boolean enQueue(int item) {
        if (isFull()) {
            System.out.println("The queue is already full!");
            return false;
        }
        items[tail] = item;
        tail ++;
        count ++;
        return true;
    }

    // 出队（队头出）
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty!");
            return -1;
        }
        int tmp = items[head];
        head ++;
        count --;
        return tmp;
    }


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        arrayQueue.enQueue(4);
        arrayQueue.deQueue();
        arrayQueue.deQueue();
        arrayQueue.enQueue(5);
        arrayQueue.enQueue(6);
        System.out.println(CommonUtils.printArrayQueue(arrayQueue));

    }
}
