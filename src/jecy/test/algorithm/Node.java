package jecy.test.algorithm;

/*
    自己定义链表元素
 */
public class Node {
    private int value;
    private Node next;

    public Node() {

    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}