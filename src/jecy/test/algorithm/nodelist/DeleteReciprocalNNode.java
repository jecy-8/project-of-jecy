package jecy.test.algorithm.nodelist;

public class DeleteReciprocalNNode {

    public static void main(String[] args) {
        Integer[] intList = {1, 2};
        NodeUtils nodeUtils = new NodeUtils();
        Node head = nodeUtils.prepareNodeList(intList);
        System.out.println("Primary list: " + NodeUtils.listAllNodes(head));
        // 删除倒数第n个节点
        int n = 2;
        Node newHead = deleteInverseNodeN(head, n);
        System.out.println("List after delete the inverse " + n + " node: " + NodeUtils.listAllNodes(newHead));

    }

    // 删除链表倒数第n个节点
    public static Node deleteInverseNodeN(Node head, int n) {
        // 先将链表反转
        Node tail = ReverseNodeList.reverseNode(head);
        // 删除第n个节点
        Node newTail = deleteNodeN(tail, n);
        // 再次反转
        Node newHead = ReverseNodeList.reverseNode(newTail);
        return newHead;

    }

    private static Node deleteNodeN(Node head, int n) {
        int size = calcNodeListSize(head);
        if (n > size) {
            System.out.println("Invalid input n, list size=" + size + ", but input n="
                    + n + ", please change to another value.");
            return null;
        }
        // 链表为空，直接返回head(null)
        if (head == null) {
            return head;
        }
        // 链表只有一个节点，将该节点置为null后返回
        if (head.getNext() == null && n == 1) {
            head = null;
            return head;
        }

        // 定义一个哨兵节点，并将其指向链表头节点
        Node dummy = new Node(-1);
        dummy.setNext(head);

        int i = 1;
        while (i < n && dummy.getNext() != null) {
            dummy = dummy.getNext();
            i ++;
        }

        // 删除最后一个节点
        if (dummy.getNext().getNext() == null) {
            dummy.setNext(null);
        }
        else {
            dummy.setNext(dummy.getNext().getNext());
        }
        // 删除的是第一个节点
        if (i == 1) {
            return dummy.getNext();
        }
        return head;

    }

    // 计算链表的长度
    private static int calcNodeListSize(Node head) {
        int i = 0;
        while (head != null) {
            head = head.getNext();
            i ++;
        }
        return i;
    }


}
