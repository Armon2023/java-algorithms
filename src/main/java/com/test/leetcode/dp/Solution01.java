package com.test.leetcode.dp;

public class Solution01 {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成
     * “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * f(i) = f(i-1) + f(i-2)[当第i位和第i-1位可以结合的时候]
     */
    public static int solve(String nums) {
        // write code here
        if (nums == null || nums.length() == 0) {
            return 0;
        } else {
            int curN = 1, preN = 0, preeN = 0;
            for (int i = 0; i < nums.length(); i++) {
                preeN = preN;
                preN = curN;
                curN = 0;
                curN += preN;
                if (i == 0) {
                    continue;
                }
                String str = nums.substring(i - 1, i + 1);
                //可以结合
                if (str.compareTo("25") < 1 && str.compareTo("10") > -1) {
                    curN += preeN;
                }
            }
            return curN;
        }
    }
}
