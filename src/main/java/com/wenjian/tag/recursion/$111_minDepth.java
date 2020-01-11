package com.wenjian.tag.recursion;

import com.wenjian.comm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class $111_minDepth {

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索


    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) {
                return 1;
            }
            int min = Integer.MAX_VALUE;
            if (root.left != null) {
                min = Math.min(minDepth(root.left), min);
            }
            if (root.right != null) {
                min = Math.min(minDepth(root.right), min);
            }
            return min + 1;
        }
    }

    /**
     * 2.bfs
     * <p>
     * 逐层遍历，遇到叶子节点马上返回当前节点
     * 叶子节点特征：left，right指针皆为null
     */
    class Solution2 {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 0;
            while (!queue.isEmpty()) {
                level++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    //碰到叶子节点。马上返回当前层级
                    if (node.left == null && node.right == null) {
                        return level;
                    }
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            return level;
        }
    }


}
