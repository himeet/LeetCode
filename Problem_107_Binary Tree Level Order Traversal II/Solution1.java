//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 373 👎 0

package com.glj.leetcode.editor.cn;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
    // 法一：广度优先遍历法(借助队列，队列翻转)
    // 算法思想：参考Problem102.二叉树的层次遍历的算法思想
    //         在二叉树的层次遍历的基础上，将最后的结果List反转一下就行
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：每个节点入队和出队各一次，时间复杂度为O(n)；List反转时间复杂度也为O(n)
    // 空间复杂度说明：队列中节点数不会超过n
    // 参考资料1：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-ceng-xu-bian-li-deng-chang-wo-yao-da-sh/(二叉树层序遍历登场：我要打十个！)
    // 参考资料2：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/er-cha-shu-de-ceng-ci-bian-li-ii-by-leetcode-solut/(官方解)
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);  // 入队
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
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
                ans.add(level);  // 官方解这里使用ans.add(0, level) 将level一直插在index=0的位置，这样就不用反转ans了
            }
            Collections.reverse(ans);  // 与Problem102.二叉树的遍历不同之处，这里需要reverse结果
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}