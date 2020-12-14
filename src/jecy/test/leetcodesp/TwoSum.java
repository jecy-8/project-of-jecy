package jecy.test.leetcodesp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 27;
        int[] finalIdx = twoSum(nums, target);
        for (int i = 0; i < finalIdx.length; i ++) {
            System.out.println(finalIdx[i]);
        }
    }

    // 如果两个下标都为0，表示没有找到满足条件的两个数
    public static int[] twoSum(int[] nums, int target) {
        int[] indexArray = new int[2];
//        List indexList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            // 标记第一个数
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j ++) {
                // 标记第二个数
                int second = nums[j];
                if (first + second == target) {
//                    indexList.add(i);
//                    indexList.add(j);
                    indexArray[0] = i;
                    indexArray[1] = j;
                    break;
                }
            }
        }
       return indexArray;
    }
}
