//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索 
// 👍 491 👎 0

package com.glj.leetcode.editor.cn;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.Queue;

public class PathSum{
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
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
    // 法二：广度优先搜索法
    // 算法思想：设置两个队列，分别存储将要遍历的节点，以及根节点到这些节点的路径和即可
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：对每个节点访问一次
    // 空间复杂度说明：空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数
    // 参考资料1：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/(官方解)
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {  // 不让空节点进入递归
                return false;
            }
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<Integer> sumQueue = new LinkedList<>();
            nodeQueue.offer(root);  // 入队
            sumQueue.offer(root.val);  // 入队
            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();  // 出队
                int currSum = sumQueue.poll();  // 出队
                if (node.left == null && node.right == null && currSum == sum) {
                    // node为叶子结点，且从root开始到node的节点val之和为题目中的sum
                    return true;
                }
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    sumQueue.offer(node.left.val + currSum);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    sumQueue.offer(node.right.val + currSum);
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}