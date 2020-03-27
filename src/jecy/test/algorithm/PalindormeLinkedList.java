package jecy.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PalindormeLinkedList {
    // 假设字符串是用单链表存储的，判断字符串是否为回文字符串

    public static boolean isPalindorme(LinkedList<Character> list) {
        int index = list.size() / 2;
        List<Character> leftPart = list.subList(0, index);
        List<Character> rightPart;
        if (list.size() % 2 == 0) {
            rightPart = list.subList(index, list.size());
        }
        else {
            rightPart = list.subList(index + 1, list.size());
        }
        if (leftPart.equals(reverseList(rightPart))) {
            return true;
        }
        return false;
    }

    private static List<Character> reverseList(List<Character> list) {
        List<Character> finalList = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i --) {
            finalList.add(list.get(i));
        }
        return finalList;
    }

    public static void main(String[] args) {
        LinkedList<Character> linkedList1 = new LinkedList<>();
        LinkedList<Character> linkedList2 = new LinkedList<>();
        LinkedList<Character> linkedList3 = new LinkedList<>();
        linkedList1.addAll(Arrays.asList('a', 'b', 'b', 'a'));
        linkedList2.addAll(Arrays.asList('a', 'b', 'c', 'b', 'a'));
        linkedList3.addAll(Arrays.asList('a', 'b', 'c', 'c', 'd'));
        System.out.println(isPalindorme(linkedList1));
        System.out.println(isPalindorme(linkedList2));
        System.out.println(isPalindorme(linkedList3));
    }


}
