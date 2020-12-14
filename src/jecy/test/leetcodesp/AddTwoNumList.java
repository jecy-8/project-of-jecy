package jecy.test.leetcodesp;

import jecy.test.algorithm.nodelist.Node;
import jecy.test.algorithm.nodelist.NodeUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AddTwoNumList {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node l3 = new Node();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        while (l1.getNext() != null) {
            list1.add(l1.getValue());
            l1 = l1.getNext();
        }
        // 加最后一个节点
        list1.add(l1.getValue());
        while (l2.getNext() != null) {
            list2.add(l2.getValue());
            l2 = l2.getNext();
        }
        // 加最后一个节点
        list2.add(l2.getValue());

        /*
            用BigDecimal是为了防止溢出，比如下例
            输入：
            [9]
            [1,9,9,9,9,9,9,9,9,9]
            预期输出：
            [0,0,0,0,0,0,0,0,0,0,1]
         */
        BigDecimal first = new BigDecimal(0);
        BigDecimal second = new BigDecimal(0);
        int i = list1.size() - 1;
        while (i >= 0) {
            BigDecimal temp = new BigDecimal((int)list1.get(i) * Math.pow(10, i));
            first = first.add(temp);
            i --;
        }

        int j = list2.size() - 1;
        while (j >= 0) {
            BigDecimal temp = new BigDecimal((int)list2.get(j) * Math.pow(10, j));
            second = second.add(temp);
            j --;
        }

        BigDecimal total = first.add(second);

        int bits = 0;
        long num = total.longValue();
        while (num >= 1) {
            num /= 10;
            bits ++;
        }

        int firstVal = (int) (total.longValue() / Math.pow(10, 0) % 10);
        l3.setValue(firstVal);
        Node index = l3;
        for (int k = 1; k < bits; k ++) {
            int value = (int) (total.longValue() / Math.pow(10, k) % 10);
            Node node = new Node();
            node.setValue(value);
            index.setNext(node);
            index = index.getNext();
        }

        return l3;

       /* 不考虑溢出，int位数内计算
        // 分别计算两个数
        int first = 0;
        int second = 0;
        for (int i = list1.size() - 1; i >= 0; i -- ) {
            first += (int) list1.get(i) * Math.pow(10, i);
        }
        for ( int i = list2.size() - 1; i >= 0; i --) {
            second += (int) list2.get(i) * Math.pow(10, i);
        }
        // 计算总数
        int total = first + second;


        // 计算总数的位数
        int bits = 0;
        int num = total;
        while (num >= 1) {
            num /= 10;
            bits ++;
        }

        // 设置第一个节点
        int firstVal = (int) (total / Math.pow(10, 0) % 10);
        l3.setValue(firstVal);
        Node index = l3;
        for (int i = 1; i < bits; i ++) {
            int value = (int) (total / Math.pow(10, i) % 10);
            Node node = new Node();
            node.setValue(value);
            index.setNext(node);
            index = index.getNext();
        }

        return l3;*/
    }

    public static void main(String[] args) {
        NodeUtils nodeUtils = new NodeUtils();
        Integer[] first = {9};
        Integer[] second = {1,9,9,9,9,9,9,9,9,9};
        Node node1 = nodeUtils.prepareNodeList(first);
        Node node2 = nodeUtils.prepareNodeList(second);
        System.out.println(NodeUtils.listAllNodes(node1));;
        System.out.println(NodeUtils.listAllNodes(node2));

        Node node3 = addTwoNumbers(node1, node2);
        System.out.println(NodeUtils.listAllNodes(node3));

    }
}
