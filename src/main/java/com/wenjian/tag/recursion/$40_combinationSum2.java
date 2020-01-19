package com.wenjian.tag.recursion;

import java.util.*;

public class $40_combinationSum2 {


    //给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。
//
// 说明：
//
//
// 所有数字（包括目标数）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
// Related Topics 数组 回溯算法


    private static class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            if (candidates == null || candidates.length == 0) return ans;
            Arrays.sort(candidates);
            helper(target, ans, 0, candidates, new ArrayDeque<>());
            return ans;
        }

        private void helper(int remain, List<List<Integer>> ans, int start, int[] candidates, Deque<Integer> deque) {
            if (remain == 0) {
                ans.add(new ArrayList<>(deque));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > remain) break;
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                deque.add(candidates[i]);
                helper(remain - candidates[i], ans, i + 1, candidates, deque);
                deque.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(list);
    }

}
