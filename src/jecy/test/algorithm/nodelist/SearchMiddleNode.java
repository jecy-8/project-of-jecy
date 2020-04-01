package jecy.test.algorithm.nodelist;

import org.w3c.dom.NodeList;

public class SearchMiddleNode {

    // 用快慢指针，每次循环慢指针走一步，慢指针走两步
    public static Node findMiddleNode(Node<Integer> head) {
        // 空链表，直接返回null
        if (head == null) {
            return null;
        }
        Node low = head;
        Node fast = head;

        while (fast != null) {
            // 说明链表长度为奇数，此时lowNode就是中间位置
            if (fast.getNext() == null) {
                return low;
            }
            // 说明链表长度为偶数，此时lowNode的位置是上中位置，可根据需求选择返回上中位置还是下中位置，这里返回下中位置
            if (fast.getNext().getNext() == null) {
                return low.getNext();
            }

            low = low.getNext();
            fast = fast.getNext().getNext();
        }

        return low;
    }

    public static void main(String[] args) {
        NodeUtils nodeUtils = new NodeUtils();
        Integer[] intList = {1, 3, 4, 6};
        Node<Integer> head = nodeUtils.prepareNodeList(intList);
        System.out.println("List=" + NodeUtils.listAllNodes(head));
        Node<Integer> middle = findMiddleNode(head);
        System.out.println("Middle node of the list is: " + (middle == null ? "null" : middle.getValue()));
    }
}
