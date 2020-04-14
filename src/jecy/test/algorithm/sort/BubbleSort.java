package jecy.test.algorithm.sort;

public class BubbleSort {

    public static void bubbleSort(int[] a) {
        int size = a.length;
        // 打印出来的是有交换的
        System.out.println("start bubbling...");
        for (int i = 0; i < size; i ++) {
            // 提前退出冒泡循环的标志
            boolean flag = false;
            for (int j = 0; j < size - i - 1; j ++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                    System.out.println(getArrayElements(a));
                }
            }
            if(!flag) {
                break;
            }
        }
    }

    public static String getArrayElements(int[] a) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length; i ++) {
            sb.append(a[i]).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        int[] a = {2,4,3,1,6,5};
        System.out.println("primary array: " + getArrayElements(a));
        bubbleSort(a);
        System.out.println("sort by bubble: " + getArrayElements(a));
    }
}
