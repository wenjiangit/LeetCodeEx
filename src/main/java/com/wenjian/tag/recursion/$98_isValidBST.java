package com.wenjian.tag.recursion;

import com.wenjian.comm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class $98_isValidBST {


    //给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索


    /**
     * 1.先进行中序遍历，后判断数据是否递增数列
     */
    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            for (int i = 1; i < res.size(); i++) {
                if (res.get(i - 1) >= res.get(i)) {
                    return false;
                }
            }
            return true;
        }


        void inorder(TreeNode root, List<Integer> res) {
            if (root != null) {
                inorder(root.left, res);
                res.add(root.val);
                inorder(root.right, res);
            }
        }
    }


    /**
     * 2.递归
     * 左子树所有节点小于跟节点
     * 右子树所有节点大于跟节点
     */
    class Solution2 {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        private boolean helper(TreeNode root, Integer lower, Integer upper) {
            if (root == null) return true;
            int val = root.val;
            if (lower != null && lower >= val) return false;
            if (upper != null && val >= upper) return false;
            boolean left = helper(root.left, lower, val);
            boolean right = helper(root.right, val, upper);
            return left && right;
        }

    }


}
