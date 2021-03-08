//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 632 👎 0

package com.glj.leetcode.editor.cn;

public class DiameterOfBinaryTree{

    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode () {}
        TreeNode (int val) { this.val = val; }
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
    // 法一：深度优先搜索
    // 算法思想：见参考资料1
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：每个结点只被访问一次
    // 空间复杂度说明：递归的深度取决于树的高度，最差为n
    // 参考资料1：https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/(官方解)
    // 备注1：递归未掌握！！
    class Solution {
        int ans;  // 全局变量，用于记录d，d为某路径的最大节点数

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            depth(root);
            return ans - 1;
        }

        /**
         * 函数返回该节点为根的子树的深度 递归调用
         * @param root
         * @return
         */
        public int depth(TreeNode root) {
            // 递归的结束条件：访问到叶子节点的子节点即空节点null
            if (root == null) {
                return 0;  // 访问到空节点了，返回0
            }

            int leftDepth = depth(root.left);  // 以左孩子为根的子树的深度
            int rightDepth = depth(root.right);  // 以右孩子为根的子树的深度
            ans = Math.max(ans, leftDepth + rightDepth + 1);  // 加1是因为要加上根节点

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}