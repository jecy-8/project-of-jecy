package jecy.test.algorithm;

public class Palindorme {

    public static boolean isPalindorme(String str) {
        int index = str.length() / 2;
        String leftPart = str.substring(0, index);
        String rightPart;
        if (str.length() % 2 == 0) {
            rightPart = str.substring(index, str.length());
        }
        else {
            rightPart = str.substring(index + 1, str.length());
        }

//        if (leftPart.equals(reverseStr(rightPart.toCharArray()))) {
//            return true;
//        }
        if (leftPart.equals(reverseStr(rightPart))) {
            return true;
        }
        return false;
    }

    /*private static String reverseStr(char[] str) {
        StringBuffer sb = new StringBuffer();
        for(int i = str.length - 1; i >= 0; i --) {
            sb.append(str[i]);
        }
        return sb.toString();
    }*/

    private static String reverseStr(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(isPalindorme("abba"));
        System.out.println(isPalindorme("abcba"));
        System.out.println(isPalindorme("abcda"));
        System.out.println("ab" == "ab");
    }
}
