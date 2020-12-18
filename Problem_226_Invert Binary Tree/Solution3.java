//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 713 👎 0

package com.glj.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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
    // 法三：迭代法
    // 算法思想：(1)先将根节点放入到队列中，然后不断的迭代队列中的元素;
    //         (2)对当前元素调换其左右子树的位置，然后：
    //            判断其左子树是否为空，不为空就放入队列中,
    //            判断其右子树是否为空，不为空就放入队列中。
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：每个节点出队入队各一次
    // 空间复杂度说明：最坏的情况下会包含所有的叶子节点，完全二叉树叶子节点是n/2个
    // 参考资料1：https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode-solution/(官方解)
    // 参考资料2：https://leetcode-cn.com/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/(王尼玛の题解)
    // 备注：迭代法即为广度优先遍历，广度优先遍历需要用到队列
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            // 将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                // 每次都从队列中拿一个节点，并交换这个节点的左右子树
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                // 如果当前节点的左子树不为空，则放入队列等待后续处理
                if(node.left != null) {
                    queue.offer(node.left);
                }
                // 如果当前节点的右子树不为空，则放入队列等待后续处理
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 返回处理完的根节点
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}