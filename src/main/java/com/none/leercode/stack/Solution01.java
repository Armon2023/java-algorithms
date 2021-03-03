package com.none.leercode.stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = '()'
//输出：true
//
//
// 示例 2：
//
//
//输入：s = '()[]{}'
//输出：true
//
//
// 示例 3：
//
//
//输入：s = '(]'
//输出：false
//
//
// 示例 4：
//
//
//输入：s = '([)]'
//输出：false
//
//
// 示例 5：
//
//
//输入：s = '{[]}'
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2201 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution01 {
    public static boolean isValid01(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    public boolean isValid02(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.isEmpty();
    }
}

