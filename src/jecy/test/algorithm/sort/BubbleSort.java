package jecy.test.algorithm.sort;

public class BubbleSort {

    public static void bubbleSort(int[] a) {
        if (a.length <= 1)
            return;
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
                    System.out.println(SortUtils.getArrayElements(a));
                }
            }
            if(!flag) {
                break;
            }
        }
    }



    public static void main(String[] args) {
        int[] a = {2,4,3,1,6,5};
        System.out.println("primary array: " + SortUtils.getArrayElements(a));
        bubbleSort(a);
        System.out.println("sort by bubble: " + SortUtils.getArrayElements(a));
    }
}
