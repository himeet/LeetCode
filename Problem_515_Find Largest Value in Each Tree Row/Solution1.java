//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 114 👎 0

package com.glj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow{
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
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
    // 法一：广度优先搜索法(借助队列)
    // 算法思想：参考Problem102.二叉树的层次遍历的算法思想
    //         在二叉树的层次遍历的基础上，改为：对于每一层遍历的节点，找到最大值，存入ans中
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是N叉树的所有节点数
    // 时间复杂度说明：每个节点入队和出队各一次
    // 空间复杂度说明：队列中节点数不会超过n
    // 参考资料1：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-ceng-xu-bian-li-deng-chang-wo-yao-da-sh/(二叉树层序遍历登场：我要打十个！)
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);  // 入队
            while (!queue.isEmpty()) {  // 遍历每一层节点
                int levelMax = Integer.MIN_VALUE;  // 每一层的最大值
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {  // 遍历当前层的所有节点
                    TreeNode node = queue.poll();  // 出队
                    levelMax = Math.max(levelMax, node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ans.add(levelMax);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}