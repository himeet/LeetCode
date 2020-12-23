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
// Related Topics 树 深度优先搜索 递归 
// 👍 866 👎 0

package com.glj.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 法二：中序遍历法(迭代法，显式表示出栈)
    // 算法思想：对二叉树进行中序遍历。若二叉树为二叉搜索树，则最后遍历得到的序列应该是严格递增的序列
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n表示二叉树的节点个数
    // 时间复杂度说明：每一个节点恰好被遍历一次，共有n个节点
    // 空间复杂度说明：递归过程中栈的开销，平均情况下为O(logn)，最坏情况下树呈现链状，为O(n)
    // 参考资料1：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/(官方解)
    // 备注1：参照Problem94. 二叉树的中序遍历
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            // 根据二叉搜索树的定义，空树也属于二叉搜索树
            if (root == null) {
                return true;
            }

            long preV = Long.MIN_VALUE;  // 当前大小比较时，表示上一个值。不能设置为Integer.MIN_VALUE，理由同方法一的解释
            TreeNode cur = root;
            Deque<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode node = stack.pop();
                if (node.val <= preV) {
                    return false;
                }
                preV = node.val;
                if (node.right != null) {
                    cur = node.right;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}