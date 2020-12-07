//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 716 👎 0
 
package com.glj.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
    // 算法思想：广度优先搜索的思想，借助队列实现，见《王道》“二叉树层次遍历”的算法思想
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：每个点进队出队各一次
    // 空间复杂度说明：队列中元素的个数不超过n个
    // 参考资料1：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-xu-bian-li-by-leetcode-solution/(官方题解)
    // 参考资料2：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/(BFS 的使用场景总结：层序遍历、最短路径问题)
    // 此题目与“剑指 Offer 32 - II. 从上到下打印二叉树 II”题目相同，本质为二叉树的层次遍历
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);  // 入队
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();  // 存储一层节点
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();  // 出队
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ans.add(level);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}