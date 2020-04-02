package jecy.test.algorithm.stack;

public class ArrayStack {
    /**
     * 用数组实现的栈
     */
    // 栈的长度
    private int size = 0;

    // 栈中元素的个数
    private int count= 0;

    // 用于存放元素的数组
    private int[] arrays;

    public ArrayStack(int size) {
        if (size <= 0) {
            System.out.println("Invalid size!");
            return;
        }
        arrays = new int[size];
        this.size = size;
    }

    // 获取栈长度
    public int getSize() {
        return size;
    }

    // 获取栈中当前元素的个数
    public int getCount() {
        return count;
    }

    // 获取栈中数组
    public int[] getStackArray() {
        return arrays;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return count == 0 ? true : false;
    }

    // 判断栈是否已满
    public boolean isFull() {
        return count == size ? true : false;
    }

    // 查看栈顶元素
    public int peek() {
        return arrays[count - 1];
    }

    // 入栈
    public boolean push(int item) {
        if (isFull()) {
            System.out.println("The stack is already full!");
            return false;
        }
        arrays[count] = item;
        count ++;
        return true;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty!");
            return -1;
        }
        int tmp = arrays[count - 1];
        count --;
        return tmp;
    }

    // 打印栈中元素
    public static String printStack(ArrayStack arrayStack) {
        int size = arrayStack.getCount();
        StringBuffer sb = new StringBuffer("{");
        for (int i = 0; i < size; i ++) {
            sb.append(arrayStack.getStackArray()[i]).append(",");
        }
        StringBuffer sb2 = new StringBuffer(sb.substring(0, sb.length() - 1));
        return sb2.append("}").toString();
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.pop();
        arrayStack.push(5);
        System.out.println(printStack(arrayStack));
        System.out.println("The top element is: " + arrayStack.peek());
    }

}
