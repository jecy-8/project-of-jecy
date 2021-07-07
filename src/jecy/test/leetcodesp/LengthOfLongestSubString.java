package jecy.test.leetcodesp;

import java.util.*;

public class LengthOfLongestSubString {

    /**
     * 利用滑动窗口
     * @param s
     * @return
     */
    public static int getLengthOfLongestSubString(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int i= 0;
        int j = 0;
        while (i < n &&j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(j - i, maxLength);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }

    /**
     * 利用优化的滑动窗口，当找到重复字符时，立马跳出该窗口
     * @param s
     * @return
     */
    public static int getLengthOfLongestSubStringOptimized(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0, j = 0; j< n; j ++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return maxLength;
    }

    /**
     * 使用list存储不重复字符
     * @param s
     * @return
     */
    public static int getLengthOfLongestSubStringUseList(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        List<Character> list = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < n; i ++) {
            int index = list.indexOf(s.charAt(i));
            if (index == -1) {
                list.add(s.charAt(i));
                maxLength = Math.max(list.size(), maxLength);
            }
            else {
                for (int j = index; j >= 0; j --) {
                    list.remove(j);
                }
                list.add(s.charAt(i));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubString("pwwkew"));
        System.out.println(getLengthOfLongestSubStringOptimized("pwwkew"));
        System.out.println(getLengthOfLongestSubStringUseList("pwwkew"));
    }
}
