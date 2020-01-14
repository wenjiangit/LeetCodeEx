package com.wenjian.tag.recursion;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class $46_permute {

    //给定一个没有重复数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法


    private static class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            backTrace(nums, new LinkedList<>());
            return res;
        }

        private void backTrace(int[] nums, LinkedList<Integer> list) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int num : nums) {
                if (list.contains(num)) {
                    continue;
                }
                list.add(num);
                backTrace(nums, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));

    }

}
