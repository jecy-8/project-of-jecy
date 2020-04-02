package jecy.test.algorithm.nodelist;

public class DeleteReciprocalNNode {

    public static void main(String[] args) {
        Integer[] intList = {1};
        NodeUtils nodeUtils = new NodeUtils();
        Node head = nodeUtils.prepareNodeList(intList);
        System.out.println("Primary list: " + NodeUtils.listAllNodes(head));
        // 删除倒数第n个节点
        int n = 1;
        Node newHead = deleteInverseNodeN3(head, n);
        System.out.println("List after delete the inverse " + n + " node: " + NodeUtils.listAllNodes(newHead));

    }

    /**
     * 删除链表倒数第n个节点
     * 解法1，先反转再删除第n个节点，最后再反转
     * @param head
     * @param n
     * @return
     */

    public static Node deleteInverseNodeN(Node head, int n) {
        // 先将链表反转
        Node tail = ReverseNodeList.reverseNode(head);
        // 删除第n个节点
        Node newTail = deleteNodeN(tail, n);
        // 再次反转
        Node newHead = ReverseNodeList.reverseNode(newTail);
        return newHead;

    }

    /**
     * 删除链表倒数第n个节点
     * 解法2：倒数第n，就是链表的第(size-n+1）个
     * @param head
     * @param n
     * @return
     */

    public static Node deleteInverseNodeN2(Node head, int n) {
        int size = calcNodeListSize(head);
        if (n > size) {
            System.out.println("Invalid input n, list size=" + size + ", but input n="
                    + n + ", please change to another value.");
            return null;
        }
        int deleleIndex = size - n + 1;
        Node newHead = deleteNodeN(head, deleleIndex);
        return newHead;
    }

    /**
     * 删除链表倒数第n个节点
     * 解法3：定义两个指针，先将第一个指针从链表的开头向前移动n+1步，第二个指针从链表的头开始，然后同时向前移动两个指针，
     * 当第一个指针到达链尾时，第二个指针的下一个节点即为要删除的节点
     * @param head
     * @param n
     * @return
     */
    public static Node deleteInverseNodeN3(Node head, int n) {
        int size = calcNodeListSize(head);
        if (n > size) {
            System.out.println("Invalid input n, list size=" + size + ", but input n="
                    + n + ", please change to another value.");
            return null;
        }
        // 删除第一个节点
        if (n == size) {
            Node dummy = new Node(-1);
            dummy.setNext(head.getNext());
            return dummy.getNext();
        }

        Node p1 = head;
        Node p2 = head;

        // 指针p1先往前移动n+1步
        int i = 0;
        while (p1 != null && i < n + 1) {
            p1 = p1.getNext();
        }
        // 指针p1和p2同时往前逐步移动
        while (p1 != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        // 此时p2的下一个节点即为要删除的节点
        p2.setNext(p2.getNext().getNext());
        return head;
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
