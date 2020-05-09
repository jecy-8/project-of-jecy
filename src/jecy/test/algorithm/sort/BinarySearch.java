package jecy.test.algorithm.sort;

public class BinarySearch {

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(a, a.length, 6));
        System.out.println(searchRecursively(a, 0, a.length - 1, 6, 0));

    }

    public static int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        int count = 0;

        while (low <= high) {
            System.out.println("第" + (++count) + "次搜索");
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            }
            else if (a[mid] < value) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }


    public static int searchRecursively(int[] a, int low, int high, int value, int count) {
        System.out.println("第" + (++count) + "次搜索");
        if (low > high) {
            return -1;
        }

        // 实际上，mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话，两者之和就有可能会溢出。
        // 改进的方法是将 mid 的计算方式写成 low+(high-low)/2。
        // 更进一步，如果要将性能优化到极致的话，我们可以将这里的除以 2 操作转化成位运算 low+((high-low)>>1)。
        // 因为相比除法运算来说，计算机处理位运算要快得多。
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        }
        else if (a[mid] < value) {
            return searchRecursively(a, mid + 1, high, value, count);
        }
        else {
            return searchRecursively(a, low, mid - 1, value, count);
        }
    }
}
