package com.wenjian.tag.recursion;

import java.util.HashMap;
import java.util.Map;

public class $70_climbStairs {


    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划


    /**
     * 1.暴力递归,时间复杂度太高为O(n^2)
     */
    private static class Solution1 {


        public int climbStairs(int n) {
            if (n <= 2) return n;
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }


    /**
     * 2.递归加记忆法，每种状态只需要计算一次，时间复杂度为O(n)
     */
    private static class Solution2 {

        Map<Integer, Integer> cache = new HashMap<>();


        public int climbStairs(int n) {
            if (n <= 2) return n;
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            int res = climbStairs(n - 1) + climbStairs(n - 2);
            cache.put(n, res);
            return res;
        }
    }


    /**
     * 3.动态规划，根据递推方程,需要额外O(n)的空间
     */
    private static class Solution3 {

        public int climbStairs(int n) {
            if (n <= 2) return n;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    /**
     * 4.变量递推,只需两个指针（最佳）
     */
    private static class Solution4 {

        public int climbStairs(int n) {
            if (n <= 2) return n;
            int prepre = 1, pre = 2;
            for (int i = 3; i <= n; i++) {
                int cur = prepre + pre;
                prepre = pre;
                pre = cur;
            }
            return pre;
        }
    }


    public static void main(String[] args) {
//        Solution1 solution1 = new Solution1();
//        long start = System.currentTimeMillis();
//        System.out.println(solution1.climbStairs(40));
//        System.out.println("time :" + (System.currentTimeMillis() - start));

        Solution2 solution2 = new Solution2();
        long start = System.currentTimeMillis();
        System.out.println(solution2.climbStairs(60));
        System.out.println("time :" + (System.currentTimeMillis() - start));


    }


}
