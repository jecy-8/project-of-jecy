package jecy.test.lightspots;

public class BitAnd {

    // 先复习下几个基本的位运算操作
    // & - 位与运算，二进制逐位比较，两位都为1结果为1
    // | - 位或运算，二进制逐位比较，任1位为1结果为1
    // ~ - 位非运算，对每位取反，0为1，1为0
    // ^ - 位异或运算，二进制逐位比较，两位不同结果为1，相同结果为0

    public static void main(String[] args) {
        // 使用“&”运算符来代替“%” num&1==0 num&3==0 num&7==0 当然只适用于2的n次幂
        int num = 16;
        System.out.println((num & 1) == 0);  // 等价于num % 2 == 0
        System.out.println((num & 3) == 0);  // 等价于num % 4 == 0
        System.out.println((num & 7) == 0);  // 等价于num % 8 == 0


        // 我们都知道，[1,2,4,8,16,32,64....]这一系列数的某一些数相加可以组合成任意的正整数，
        // 而当我们要判断一个任意的正整数中是否存在上面一系列数中的某一个数时，我们就可以用到“&”运算符
        // 计算出来的结果就是被&的那个数
        int a = 28;
        System.out.println(a & 16);
        System.out.println(a & 8);
        System.out.println(a & 4);
    }
}
