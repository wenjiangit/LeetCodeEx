package com.wenjian.tag.recursion;

import com.wenjian.comm.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class $105_buildTree {

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组


    /**
     * 递归
     * 1.先序遍历可以确定树的根节点
     * 2.由根节点可以划分左右两个子树并确定子树的节点范围
     * 3.重复12
     */
    class Solution {

        private int preIndex = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> cache = new HashMap<>();
            int index = 0;
            for (int i : inorder) {
                cache.put(i, index++);
            }
            return helper(preorder, cache, 0, preorder.length - 1);
        }

        private TreeNode helper(int[] preorder, Map<Integer, Integer> cache, int lo, int hi) {
            if (lo > hi) return null;
            int val = preorder[preIndex];
            int index = cache.get(val);
            TreeNode node = new TreeNode(val);
            //每构建一个节点，先序遍历的index++
            preIndex++;
            node.left = helper(preorder, cache, lo, index - 1);
            node.right = helper(preorder, cache, index + 1, hi);
            return node;
        }
    }

}
