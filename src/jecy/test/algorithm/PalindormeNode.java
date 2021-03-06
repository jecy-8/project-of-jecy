package jecy.test.algorithm;

import jecy.test.algorithm.nodelist.Node;

public class PalindormeNode {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 4, 3, 2, 1, 0};
        // 准备数据
        Node headNode = prepareData(a);
        System.out.println(printNodeList(headNode));

        // 获取中结节
        Node middleNode = getMiddleNode(headNode);

        // 将后半段逆序
        Node reverseNode = reverseNode(middleNode);

        // 判断是否为回文
        boolean isPalindrome = isPalindrome(headNode, reverseNode);

        // 将后半段逆序复原
        middleNode = reverseNode(reverseNode);

        if (isPalindrome) {
            System.out.println("The list is palindrome.");
        }
        else {
            System.out.println("The list is not palindrome.");
        }

    }

    // 判断是否是回文
    private static boolean isPalindrome(Node headNode, Node middleNode) {
        // 中间节点肯定在头节点后面，会先走到终点
        while(middleNode.getNext() != null) {
            if(headNode.getValue() != middleNode.getValue()) {
                return false;
            }
            headNode = headNode.getNext();
            middleNode = middleNode.getNext();
        }
        return true;
    }

    // 反转指定节点之后的节点
    private static Node reverseNode(Node headNode) {
        Node tempNode = headNode.getNext();
        Node flagNode = tempNode.getNext();

        // 断开初始节点跟后面的节点
        headNode.setNext(null);

        while(flagNode != null) {
            tempNode.setNext(headNode);
            headNode = tempNode;
            tempNode = flagNode;
            flagNode = flagNode.getNext();
        }
        tempNode.setNext(headNode);
        return tempNode;
    }

    private static String printNodeList(Node headNode) {
        StringBuffer sb = new StringBuffer("");
        // 单链表尾为空，直接返回空字符串
        if (headNode == null) {
            return sb.toString();
        }
        // 链表头节点
        sb.append(headNode.getValue().toString());
        while(headNode.getNext() != null) {
            sb.append(",").append(headNode.getNext().getValue().toString());
            headNode = headNode.getNext();
        }
        sb.substring(0, sb.length()-1);
        return sb.toString();
    }


    // 初始化链表
    private static Node prepareData(int[] a) {
        Node headNode = new Node(0);
        Node current = headNode;
        for (int i = 0; i < a.length; i ++) {
            Node temp = new Node(a[i]);
            current.setNext(temp);
            current = temp;
        }
        return headNode;
    }

    // 找到中节点
    private static Node getMiddleNode(Node headNode) {
        // 定义两个指针，一个快指针，一个慢指针
        Node lowNode = headNode;
        Node fastNode = headNode;

        // 慢指针一次走一步，快指针一次走两步，快指针走到终点时，慢指针刚好处于中点位置
        while (fastNode != null) {
            // 说明链表长度为奇数，此时lowNode就是中间位置
            if (fastNode.getNext() == null) {
                return lowNode;
            }
            // 说明链表长度为偶数，此时lowNode的位置是上中位置，可根据需求选择返回上中位置还是下中位置，这里返回下中位置
            if (fastNode.getNext().getNext() == null) {
                return lowNode.getNext();
            }

            // 慢指针一次走一步
            lowNode = lowNode.getNext();
            // 快指针一次走两步
            fastNode = fastNode.getNext().getNext();
        }
        return lowNode;
    }


}
