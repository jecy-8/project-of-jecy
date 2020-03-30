package jecy.test.algorithm;

public class ReverseNodeList {

    // 反转单链表，输入链表的头节点，输出链表的尾结点
    public static Node reverseNode(Node headNode) {
        // 单链表为空，或者只有一个节点，直接返回头结点
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }
        // 单链表只有两个节点，直接反转
        if (headNode.getNext().getNext() == null) {
            Node temp = headNode.getNext();
            headNode.setNext(null);
            temp.setNext(headNode);
            return temp;
        }
        Node tempNode = headNode.getNext();
        Node flagNode = tempNode.getNext();

        // 初始化反转后的尾结点，即反转前链表的头节点
        headNode.setNext(null);

        // 开始反转
        while (flagNode != null) {
            tempNode.setNext(headNode);
            headNode = tempNode;
            tempNode = flagNode;
            flagNode = flagNode.getNext();
        }

        // 当flagNode=null的时候，tempNode为尾结点，需要将其指向headNode
        tempNode.setNext(headNode);
        return tempNode;
    }

    public static void main(String[] args) {
        String[] strList = {"a", "b", "c", "d"};
        NodeUtils nodeUtils = new NodeUtils();
        Node<String> headNode = nodeUtils.prepareNodeList(strList);
        System.out.println("Primary list: " + NodeUtils.listAllNodes(headNode));
        Node<String> newHeadNode = reverseNode(headNode);
        System.out.println("List after reverse: " + NodeUtils.listAllNodes(newHeadNode));
        ;
    }
}
