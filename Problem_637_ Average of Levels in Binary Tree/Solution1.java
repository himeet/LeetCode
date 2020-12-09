//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 217 👎 0

package com.glj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    // 法一：广度优先搜索法(借助队列)
    // 算法思想：参考Problem102.二叉树的层次遍历的算法思想
    //         在二叉树的层次遍历的基础上，在遍历每一层时，计算每一层的平均值，加入到ans中
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：每个节点入队和出队各一次
    // 空间复杂度说明：每个节点最多进队一次，故队列中节点数不会超过n
    // 参考资料1：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-ceng-xu-bian-li-deng-chang-wo-yao-da-sh/(二叉树层序遍历登场：我要打十个！)
    // 参考资料2：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/solution/er-cha-shu-de-ceng-ping-jun-zhi-by-leetcode-soluti/(官方解)
    // 备注：深度优先遍历方法未看
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);  // 入队
            while (!queue.isEmpty()) {
                double levelSum = 0;
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();
                    levelSum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ans.add(levelSum / currentLevelSize);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}