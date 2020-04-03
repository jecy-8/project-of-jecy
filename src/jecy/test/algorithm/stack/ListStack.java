package jecy.test.algorithm.stack;

import jecy.test.algorithm.CommonUtils;
import jecy.test.algorithm.nodelist.Node;

public class ListStack {
    /**
     * 用链表实现的栈
     */
    // 链表的头节点，即栈顶
    private Node head;
    // 链表的长度
    private int size = 0;
    // 链表元素的个数
    private int count = 0;

    // 构造一个空的链表
    public ListStack() {
        this.head = null;
    }

    // 构造一个自定义长度的链表
    public ListStack(int size) {
        this.head = null;
        this.size = size;
    }

    // 设置头节点
    public void setHeader(Node head) {
        this.head = head;
    }

    // 获取头节点
    public Node getHeader() {
        return this.head;
    }

    // 获取栈的长度
    public int getSize() {
        return this.size;
    }

    // 获取栈中元素的个数
    public int getCount() {
        return this.count;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return this.count == 0 ? true : false;
    }

    // 判断栈是否已满
    public boolean isFull() {
        return this.count == size ? true : false;
    }

    // 入栈
    public boolean push(Node node) {
        if (isFull()) {
            System.out.println("The stack is already full!");
            return false;
        }
        node.setNext(head);
        this.head = node;
        count ++;
        return true;
    }

    // 出栈
    public Object pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty!");
            return null;
        }
        Object tmp = head.getValue();
        head = head.getNext();
        count --;
        return tmp;
    }

    // 查看栈顶元素
    public Object peek() {
        return head.getValue();
    }


    public static void main(String[] args) {
        ListStack listStack = new ListStack(10);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        listStack.push(n1);
        listStack.push(n2);
        listStack.push(n3);
        listStack.push(n4);
        listStack.pop();
        listStack.push(n5);
        System.out.println(CommonUtils.printListStack(listStack));
        System.out.println("The top element is: " + listStack.peek());
    }
}
