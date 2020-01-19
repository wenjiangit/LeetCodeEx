package com.wenjian.tag.recursion;

import java.util.*;
import java.util.stream.Collectors;

public class $47_permuteUnique {


    //给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// Related Topics 回溯算法


    private static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(res, nums, new ArrayList<>());
            return res;
        }

        private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> list) {
            if (list.size() == nums.length) {
                List<Integer> collect = list.stream().map(i -> nums[i]).collect(Collectors.toList());
                if (!res.contains(collect)) {
                    res.add(collect);
                }
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (list.contains(i)) {
                    continue;
                }
                list.add(i);
                backtrack(res, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }


    private static class Solution1 {

        private boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            used = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(res, nums, new ArrayDeque<>());
            return res;
        }

        private void backtrack(List<List<Integer>> res, int[] nums, Deque<Integer> list) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                        continue;
                    }
                    list.addLast(nums[i]);
                    used[i] = true;
                    backtrack(res, nums, list);
                    list.removeLast();
                    used[i] = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }

}
