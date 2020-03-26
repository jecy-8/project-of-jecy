package jecy.test.datastructure;

import java.util.Arrays;
import java.util.LinkedList;

/*
   用链表实现LHR(Least Recent Used)缓存淘汰算法：
   假设我们维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
   1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
   2. 如果此数据没有在缓存链表中，又可以分为两种情况：
      1）如果此时缓存未满，则将此结点直接插入到链表的头部；
      2）如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
*/
public class LHRByLinkedList {

    private static int CACHE_SIZE = 10;

    public static void lhrByLinkedList(LinkedList<Object> linkedList, Object n) {
        // 已经在缓存链表中
        if (linkedList.contains(n)) {
            linkedList.remove(n);
            linkedList.addFirst(n);
        }
        // 不在缓存链表中
        else {
            // 缓存已满
            if (linkedList.size() == CACHE_SIZE) {
                linkedList.removeLast();
                linkedList.addFirst(n);
            }
            // 缓存未满
            else {
                linkedList.addFirst(n);
            }
        }

    }
    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.addAll(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i"));
        System.out.println("Linked list before search: \n" + linkedList.toString());
        // 元素在链表中
        lhrByLinkedList(linkedList, "b");
        System.out.println("Linked list after search 'b': \n" + linkedList.toString());

        // 元素不在链表中，链表未满
        lhrByLinkedList(linkedList, "j");
        System.out.println("Linked list after search 'j': \n" + linkedList.toString());

        // 元素不在链表中，链表已满
        lhrByLinkedList(linkedList, "k");
        System.out.println("Linked list after search 'k': \n" + linkedList.toString());
    }
}
