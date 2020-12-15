//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1157 👎 0

package com.glj.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
    // 法二：迭代法-2.0
    // 算法思想：(1)引入一个队列。初始化时将根结点入队2次，每次提取两个节点并比较他们的值(若为对称树，则队列中每两个连续的
    //            节点应该是相等的，而且他们的子树互为镜像)，然后将两个节点的左右子节点按相反的顺序插入队列中；
    //         (2)当队列为空，或者我们检测到树不对称（即从队列中取出两个不相等的连续节点时），算法结束
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：遍历了这棵树的所有节点
    // 空间复杂度说明：需要维护一个队列，队列中节点个数不会超过n
    // 参考资料1：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/(官方解)
    // 参考资料2：https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 用队列保存节点
            Queue<TreeNode> queue = new LinkedList<>();
            // 将根节点的左右孩子放入队列中
            queue.offer(root);
            queue.offer(root);
            while (!queue.isEmpty()) {
                //从队列中取出两个节点，再比较这两个节点
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                //如果两个节点都为空就继续循环，两者有一个为空就返回false
                if (left == null && right == null) {
                    continue;
                }
                if ((left == null && right != null) || (left != null && right == null)) {
                    return false;
                }
                // 两个节点的值不相等返回false
                if (left.val != right.val) {
                    return false;
                }
                // 将左节点的左孩子 和 右节点的右孩子入队
                queue.offer(left.left);
                queue.offer(right.right);
                // 将左节点的右孩子 和 右节点的左孩子入队
                queue.offer(left.right);
                queue.offer(right.left);
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}