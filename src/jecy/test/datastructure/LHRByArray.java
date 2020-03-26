package jecy.test.datastructure;

/*
   用数组实现LHR(Least Recent Used)缓存淘汰算法：
   假设我们维护一个有序数组，越靠近数组末尾的结点是越早之前访问的。当有一个新的数据被访问时，我们遍历数组。
   1. 如果此数据之前已经被缓存在数组中了，我们遍历得到这个元素，并将其和数组中第一个元素互换位置。
   2. 如果此数据没有在缓存数组中，又可以分为两种情况：
      1）如果此时缓存未满，将所有的元素往后挪一个位置，再将查找的元素插入到第一个位置；
      2）如果此时缓存已满，删掉数组末尾的元素，再将所有元素往后挪一个位置，最后将查找的元素插入到第一个位置。
*/
public class LHRByArray {

    private static int CACHE_MAX = 10;

    public static void lhrByArray(String[] array, String data) {
        int i = 0;
        for(; i < array.length; i ++) {
            // 已经在缓存数组中
            if(data == array[i]) {
                String temp = array[0];
                array[0] = data;
                array[i] = temp;
                return;
            }
        }
        // 不在缓存数组中
        // 缓存已满
        if(i == CACHE_MAX) {
            // 直接将数组元素往后挪一位，最后的元素被丢弃，被查找的元素插入到数组首位
            moveForward(array, data);
        }
        // 缓存未满
        else {
            // 先将元素加到数组末尾
            array[array.length] = data;
            // 再将数组元素往后挪一位，被查找的元素插入到数组首位
            moveForward(array, data);
        }
    }

    private static void moveForward(String[] array, String data) {
        for(int k = array.length - 1; k > 0; k --) {
            array[k] = array[k - 1];
        }
        array[0] = data;
    }

    private static String showArray(String[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i ++) {
            if(array[i] != null) {
                sb.append(array[i]).append(",");
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    private static void initArray(String[] array) {
        String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        for (int i = 0; i < arr.length; i ++) {
            array[i] = arr[i];
        }
    }


    public static void main(String[] args) {
        String[] array = new String[CACHE_MAX];
        initArray(array);
        System.out.println("Array before search: \n" + showArray(array));
        // 元素在数组中
        lhrByArray(array, "b");
        System.out.println("Array after search 'b': \n" + showArray(array));

        // 元素不在数组中，数组未满
        lhrByArray(array, "j");
        System.out.println("Array after search 'j': \n" + showArray(array));

        // 元素不在数组中，数组已满
        lhrByArray(array, "k");
        System.out.println("Array after search 'k': \n" + showArray(array));
    }

}
