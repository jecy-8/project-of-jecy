package jecy.test.algorithm.sort;

public class MergeSort {
    /*
        递归排序将待排序的序列依次拆分为两个长度相等的子序列，为每一个子序列排序
        最终将排序好的子序列合并成一个有序序列
     */

    public static void main(String[] args) {
        int arr[] = {2,1,5,3,6,4,9,8,7};
//        int arr[] = { 49, 38, 65, 97, 76, 13, 27, 50 };
        System.out.println(SortUtils.getArrayElements(arr));
        mergeSort(arr, 0, 8);
        System.out.println(SortUtils.getArrayElements(arr));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        // 当子序列中只有一个元素时结束递归
        if (start < end) {
            // 划分子序列
            int mid = (start + end) / 2;
            // 对左侧子序列进行递归排序
            mergeSort(arr, start, mid);
            // 对右侧子序列进行递归排序
            mergeSort(arr, mid+1, end);
            // 合并
            merge(arr, start, mid, end);
        }
    }

    // 两路归并算法，两个排好序的子序列合并成一个子序列
    private static void merge(int[] arr, int left, int mid, int right) {
        // 辅助数组
        int tmp[] = new int[arr.length];
        // p1,p2是检测指针，k是存放指针
        int p1, p2, k;
        // p1从左侧子序列最左边开始
        p1 = left;
        // p2从右侧子序列最左边开始
        p2 = mid + 1;
        k = left;

        // p1,p2分别从两个子序列从左往右扫描，依次取两个中小的元素放入辅助数组
        while(p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                tmp[k++] = arr[p1++];
            }
            else {
                tmp[k++] = arr[p2++];
            }
        }

        // 左子序列中还有元素未检测完，直接将后面所有元素加入辅助数组
        while(p1 <= mid) {
            tmp[k++] = arr[p1++];
        }

        // 右子序列中还有元素未检测完，直接将后面所有元素加入辅助数组
        while(p2 <= right) {
            tmp[k++] = arr[p2++];
        }

        // 将所有元素复制到原数组
        for (int i = left; i <=right; i ++) {
            arr[i] = tmp[i];
        }

    }
}
