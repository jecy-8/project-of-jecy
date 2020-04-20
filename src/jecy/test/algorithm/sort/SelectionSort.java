package jecy.test.algorithm.sort;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i ++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {2,1,5,3,6,4,9,8,7};
        System.out.println(SortUtils.getArrayElements(arr));
        selectionSort(arr);
        System.out.println(SortUtils.getArrayElements(arr));
    }
}
