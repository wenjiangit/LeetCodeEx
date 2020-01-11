package com.wenjian.tag.recursion;

//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为：
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.List;

class $22_generateParenthesis {

    /**
     * 方法一
     * 递归加剪枝，套用递归模板
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, 0, n, ans, "");
        return ans;
    }

    private void generate(int left, int right, int n, List<String> ans, String cur) {
        if (left + right == 2 * n) {
            ans.add(cur);
            return;
        }
        if (left < n) generate(left + 1, right, n, ans, cur + "(");
        if (right < left) generate(left, right + 1, n, ans, cur + ")");
    }


    /************************************************************************/


    /**
     * 方法二
     * 递归，先暴力枚举，最后再检验
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        generate2(0, 0, n, ans, "");
        return ans;
    }

    private void generate2(int left, int right, int n, List<String> ans, String cur) {
        if (left + right == 2 * n) {
            //最后再校验
            if (isValid(cur)) {
                ans.add(cur);
            }
            return;
        }
        //暴力枚举所有情况
        generate2(left + 1, right, n, ans, cur + "(");
        generate2(left, right + 1, n, ans, cur + ")");
    }

    private boolean isValid(String cur) {
        int balance = 0;
        for (char c : cur.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) return false;
        }
        return balance == 0;
    }


    public static void main(String[] args) {
        $22_generateParenthesis solution = new $22_generateParenthesis();


       /* List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
       */

        List<String> strings = solution.generateParenthesis2(3);
        System.out.println(strings);


    }


}


