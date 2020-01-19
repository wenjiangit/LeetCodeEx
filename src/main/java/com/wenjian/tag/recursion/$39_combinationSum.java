package com.wenjian.tag.recursion;

import java.util.*;

public class $39_combinationSum {


    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// Related Topics 数组 回溯算法


    /**
     * 回溯加剪枝
     */
    private static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            //先排序
            Arrays.sort(candidates);
            helper(target, 0, candidates, ans, new ArrayDeque<>());
            return ans;
        }

        private void helper(int remain, int start, int[] candidates, List<List<Integer>> ans, Deque<Integer> deque) {
            if (remain == 0) {
                ans.add(new ArrayList<>(deque));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                //因为前面已排序，遇到大于目标值的直接break
                if (candidates[i] > remain) break;
                deque.add(candidates[i]);
                helper(remain - candidates[i], i, candidates, ans, deque);
                deque.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        List<List<Integer>> list = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> list = solution.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(list);
    }

}
