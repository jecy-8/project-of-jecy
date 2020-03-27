package jecy.test.algorithm;

public class PalindormeNode {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 4, 3, 2, 1, 0};
        // 准备数据
        Node headNode = prepareData(a);

        // 获取中结节
        Node middleNode = getMiddleNode(headNode);

        // 将后半段逆序
        Node reverseNode = reverseNode(middleNode);

        // 判断是否为回文
        boolean isPalindrome = isPalindrome(headNode, reverseNode);

        // 将后半段逆序复原
        middleNode = reverseNode(reverseNode);

        System.out.println(isPalindrome);
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
       /* Node fastNode = null;
        if(lowNode != null){
            fastNode = lowNode.getNext();
        }*/
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
