package com.wenjian.tag.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class $77_combine {


    //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法


    private static class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backTrace(1, n, k, new Stack<>());
            return res;
        }

        private void backTrace(int start, int n, int k, Stack<Integer> stack) {
            if (stack.size() == k) {
                ArrayList<Integer> list = new ArrayList<>(stack);
                res.add(list);
                return;
            }
            for (int i = start; i <= n; i++) {
                stack.push(i);
                backTrace(i + 1, n, k, stack);
                stack.pop();
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }

}
