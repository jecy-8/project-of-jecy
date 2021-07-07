package jecy.test.algorithm.sort;

public class QuickSort {

    /*
        1. 选取序列最左侧位置元素为基准值k
        2. 设置两个哨兵i,j分别从左右两端开始探测
        3. 当满足i<j时，哨兵j先出动，从右往左扫描，碰到小于k的元素停止；哨兵i出动，从左往右扫描，碰到大于k的元素停止
        5. 当满足i<j时，交换i,j位置的元素
        6. 当哨兵i,j相遇时，探测结束，将基准值与i,j此时位置的值交换
        7. 依次递归基准值左边的序列和右边的序列
     */
    public static void main(String[] args) {
        int arr[] = {2,1,5,3,6,4,9,8,7};
        System.out.println(SortUtils.getArrayElements(arr));
        quickSort2(arr, 0, 8);
        System.out.println(SortUtils.getArrayElements(arr));
    }

    // left,right分别为数组arr的最开始和最末尾的下标
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int i,j,key;
        // 设置i,j两个哨兵，i从左往右扫描，j从右往左扫描
        i = left;
        j = right;
        // key为基准值，选取第一个元素作为基准值
        // 基准值选取第一个，先从右边开始扫描；如果基准值选取最后一个，就需要先从左边开始扫描
        key = arr[left];

        // 左右两边扫描，直到i=j
        while(i < j) {
            // 先从右往左扫描，找到比基准值小的元素
            while (key <= arr[j] && i < j) {
                j --;
            }

            // 再从左往右扫描，找到比基准值大的元素
            while (key >= arr[i] && i < j) {
                i ++;
            }

            // 满足条件就交换
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 最后将基准位与i=j位置的值交换
        arr[left] = arr[i];
        arr[i] = key;

        System.out.println("基于基准位 " + key + " 排序后数组变为：" + SortUtils.getArrayElements(arr));

        // 递归调用基准值左边的数组
        quickSort(arr, left, j-1);

        // 递归调用基准值右边的数组
        quickSort(arr, j+1, right);
    }

    public static void quickSort2(int arr[], int left, int right) {
        int i = left, j = right;
        int base;
        if (i < j) {
            // 以最左边的节点为基准数
            base = arr[i];
            while (i != j) {
                // 从右往左扫描，寻找比基准数小的元素
                while (j > i && arr[j] > base) --j;
                // 将比基准数小的元素放到left所在的位置
                arr[i] = arr[j];
                // 从左往右扫描，寻找比基准数大的元素
                while (i < j && arr[i] < base) ++i;
                // 将比基准数大的元素放到right所在的位置
                arr[j] = arr[i];
            }
            // 将基准数放到i,j重合的地方
            arr[i] = base;
            // 以基准数节点为分割点，分别递归处理左边和右边
            quickSort2(arr, left, i - 1);
            quickSort2(arr, i + 1, right);
        }
    }
}
