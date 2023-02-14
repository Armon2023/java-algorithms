package com.test.leetcode;


/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class Solution125 {
    //stack或者双指针
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < s.length() && j > i; ) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
