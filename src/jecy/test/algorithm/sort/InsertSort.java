package jecy.test.algorithm.sort;

public class InsertSort {

    public static void insertSort(int[] arr) {
        int temp;

        for (int i=1;i<arr.length;i++){

            //待排元素小于有序序列的最后一个元素时，向前插入
            if (arr[i]<arr[i-1]){
                temp = arr[i];
                for (int j=i;j>=0;j--){
                    if (j>0 && arr[j-1]>temp) {
                        arr[j]=arr[j-1];
                    }else {
                        arr[j]=temp;
                        break;
                    }
                }
            }
        }
    }

    public static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j --;
            }
            arr[j+1] = temp;
        }
    }

    public static void printArr(int[] arr) {
        StringBuffer sb = new StringBuffer("{");
        for (int i = 0; i < arr.length; i ++) {
            sb.append(arr[i]).append(",");
        }
        sb.deleteCharAt(sb.toString().length() - 1);
        sb.append("}");
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        int arr[] = {2,1,5,3,6,4,9,8,7};
        printArr(arr);
        insertSort2(arr);
        printArr(arr);
    }
}
