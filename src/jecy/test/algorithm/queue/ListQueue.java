package jecy.test.algorithm.queue;

import jecy.test.algorithm.CommonUtils;
import jecy.test.algorithm.nodelist.Node;

public class ListQueue {
    /**
     * 用链表实现的队列
     */
    // 队列的头节点
    private Node head;

    // 队列的尾节点
    private Node tail;

    // 队列中元素的个数
    private int count;

    public ListQueue() {
        Node dummy = new Node(-1);
        head = dummy;
        tail = dummy;
    }

    // 获取链表队列头节点
    public Node getHead() {
        return head;
    }

    // 获取链表队列尾节点
    public Node getTail() {
        return tail;
    }

    // 获取链表队列中节点的个数
    public int getCount() {
        return count;
    }

    // 入队
    public boolean enQueue(Node node) {
        tail.setNext(node);
        tail = tail.getNext();
        count ++;
        return true;
    }

    // 出队
    public Node deQueue() {
        Node node = head.getNext();
        head = head.getNext();
        count --;
        return node;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        ListQueue listQueue = new ListQueue();
        listQueue.enQueue(n1);
        listQueue.enQueue(n2);
        listQueue.enQueue(n3);
        listQueue.enQueue(n4);
        System.out.println("Node " + listQueue.deQueue().getValue() + " has been dequeued.");;
        listQueue.enQueue(n5);
        System.out.println(CommonUtils.printListQueue(listQueue));
    }
}
