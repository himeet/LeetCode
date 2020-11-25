//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 
// 👍 527 👎 0
 
package com.glj.leetcode.editor.cn;

public class BalancedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
    }
    class TreeNode {
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
    // 法二：自底向上的递归
    // 算法思想：(1)定义函数height，用于计算二叉树中的任意一个结点p的高度:
    //          若p是空结点，height(p) = 0；若p是非空结点，height(p) = max(height(p.left), height(p.right)) + 1
    //          (2)平衡二叉树的定义为：二叉树的每个结点的左右子树的高度差的绝对值不超过1
    //          (3)根据定义，一棵二叉树是平衡二叉树，当且仅当其所有子树也都是平衡二叉树，因此可以使用递归的方式判断
    //          (4)本法中自底向上的递归：类似于后序遍历，对于当前遍历到的结点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡
    //             如果一颗子树是平衡的，返回其高度(高度一定是非负整数)，否则返回-1。如果存在一颗子树不平衡，则整个二叉树不平衡
    // 时间复杂度：O(n)，空间复杂度：O(n) 其中n是二叉树中的节点个数
    // 时间复杂度说明：使用自底向上的递归，每个节点的计算高度和判断是否平衡都只需要处理一次，最坏情况下需要遍历二叉树中的所有节点
    // 空间复杂度说明：空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过n
    // 参考资料：https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode-solution/
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
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        /**
         * 计算任意节点p的高度并判断是否是平衡二叉树，是则返回>=0的高度，否则返回-1
         * @param root
         * @return
         */
        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}