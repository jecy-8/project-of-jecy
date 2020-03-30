package jecy.test.algorithm;

public class LoopDetector {

    public static boolean hasLoop(Node headNode) {
        if (headNode == null || headNode.getNext() == null) {
            return false;
        }

        Node slowNode = headNode;
        Node fastNode = headNode;

        while(fastNode != null && fastNode.getNext() != null) {
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();

            // 快指针已到链尾
            if (fastNode == null) {
                return false;
            } else if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // 创建一个有loop的链表，尾结点e指向中间节点c
        String[] str = {"a", "b", "c", "d", "e"};
        Node<String> head = new Node<>(str[0]);
        Node<String> p1 = new Node<>(str[1]);
        Node<String> p2 = new Node<>(str[2]);
        Node<String> p3 = new Node<>(str[3]);
        Node<String> p4 = new Node<>(str[4]);
        head.setNext(p1);
        p1.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);
        p4.setNext(p2);
        // 链表中含有环，直接调用listAllNodes会出现无限死循环
//        System.out.println("Primary list is: " + NodeUtils.listAllNodes(head));
        if (hasLoop(head)) {
            System.out.println("Loop detected inside list.");
        } else {
            System.out.println("No loop detected.");
        }

    }
}
