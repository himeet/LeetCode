//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 634 👎 0

package com.glj.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees{
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
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
    // 法二：广度优先遍历
    // 算法思想：见参考资料1的介绍
    // 时间复杂度：O(min(m, n))，空间复杂度：O(min(m, n))  其中m和n分别是两个二叉树的节点个数
    // 时间复杂度说明：对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会对该节点进行显性合并操作，
    //              因此被访问到的节点数不会超过较小的二叉树的节点数
    // 空间复杂度说明：间复杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数
    // 参考资料1：https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/(官方解)
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }

            // 构造三个queue，用于辅助层序遍历
            TreeNode merged = new TreeNode(root1.val + root2.val);
            Queue<TreeNode> queue = new LinkedList<>();  // 用于对合并后的二叉树进行层序遍历
            Queue<TreeNode> queue1 = new LinkedList<>();  // 用于对root1进行层序遍历
            Queue<TreeNode> queue2 = new LinkedList<>();  // 用于对root2进行层序遍历

            // 初始化三个queue
            queue.offer(merged);  // 入队
            queue1.offer(root1);  // 入队
            queue2.offer(root2);  // 入队

            // 开始合并过程
            while (!queue1.isEmpty()  && !queue2.isEmpty()) {
                TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();  // 出队
                TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;

                // 处理node的左孩子
                // left1和left2均为空时，不做任何处理
                if (left1 != null && left2 != null) {  // 都不为空，合并后的为二者的和
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    // 扩展下一层节点
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null && left2 == null) { // 当有一个做孩子不为null时，不用加入队列的是因为，node.left=left1就会将left1及下面的一连串全部串到了node.left上了
                    node.left = left1;
                } else if (left1 == null && left2 != null) {
                    node.left = left2;
                }

                // 处理node的右孩子
                if (right1 != null && right2 != null) {
                     TreeNode right = new TreeNode(right1.val + right2.val);
                     node.right = right;
                     // 扩展下一层节点
                     queue.offer(right);
                     queue1.offer(right1);
                     queue2.offer(right2);
                } else if (right1 != null && right2 == null) {
                    node.right = right1;
                } else if (right1 == null && right2 != null) {
                    node.right = right2;
                }

            }

            return merged;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}