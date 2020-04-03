package jecy.test.algorithm;

import jecy.test.algorithm.nodelist.Node;
import jecy.test.algorithm.queue.ArrayQueue;
import jecy.test.algorithm.queue.CircularQueue;
import jecy.test.algorithm.stack.ArrayStack;
import jecy.test.algorithm.stack.ListStack;

public class CommonUtils {

    // 打印数组栈中元素
    public static String printArrayStack(ArrayStack arrayStack) {
        int size = arrayStack.getCount();
        StringBuffer sb = new StringBuffer("{");
        for (int i = 0; i < size; i ++) {
            sb.append(arrayStack.getStackArray()[i]).append(",");
        }
        StringBuffer sb2 = new StringBuffer(sb.substring(0, sb.length() - 1));
        return sb2.append("}").toString();
    }

    // 打印队列栈中的元素
    public static String printListStack(ListStack listStack) {
        Node head = listStack.getHeader();
        StringBuffer sb = new StringBuffer("{");
        while (head != null) {
            sb.append(head.getValue().toString()).append(",");
            head = head.getNext();
        }
        StringBuffer sb2 = new StringBuffer(sb.substring(0, sb.length() - 1));
        return sb2.append("}").toString();
    }


    // 打印数组队列中的元素
    public static String printArrayQueue(ArrayQueue arrayQueue) {
        StringBuffer sb = new StringBuffer("{");
        for (int i = arrayQueue.getHead(); i < arrayQueue.getTail(); i ++) {
            sb.append(arrayQueue.getItems()[i]).append(",");
        }
        StringBuffer sb2 = new StringBuffer(sb.substring(0, sb.length() - 1));
        return sb2.append("}").toString();
    }

    // 打印循环队列中的元素
    public static String printCircularQueue(CircularQueue circularQueue) {
        StringBuffer sb = new StringBuffer("{");
        int index = circularQueue.getHead();
        while (index != circularQueue.getTail()) {
            sb.append(circularQueue.getItems()[index]).append(",");
            index = (index + 1) % circularQueue.getSize();
        }
        StringBuffer sb2 = new StringBuffer(sb.substring(0, sb.length() - 1));
        return sb2.append("}").toString();
    }


}
