//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 297 👎 0

package com.glj.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers{
    public static void main(String[] args) {
        Solution solution = new SumRootToLeafNumbers().new Solution();
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
    // 法二：广度优先遍历法
    // 算法思想：维护两个队列，分别存放待遍历的节点和每个节点对应的数字
    //         初始时，将根节点和根节点的值分别加入两个队列。每次从两个队列分别
    //         取出一个节点和一个数字，进行如下操作：
    //        （1）如果当前节点是叶子节点，则将该节点对应的数字加到数字之和；
    //        （2）如果当前节点不是叶子节点，则获得当前节点的非空子节点，并根据当
    //            前节点对应的数字和子节点的值计算子节点对应的数字，然后将子节点
    //            和子节点对应的数字分别加入两个队列。
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：对每个节点访问一次
    // 空间复杂度说明：空间复杂度主要取决于递归调用的栈空间，递归栈的深度等于二叉树的高度，最坏情
    //              况下，二叉树的高度等于节点个数，空间复杂度为O(n)
    // 参考资料1：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/(官方解)
    // 参考资料2：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/129-qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-di-4/(代码随想录)
    class Solution {
        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int ans = 0;  // 盛放最终的和 累加和(遇到叶子节点时累加)

            Queue<TreeNode> nodeQueue = new LinkedList<>();  // 盛放待遍历的节点
            Queue<Integer> numQueue = new LinkedList<>();   // 盛放nodeQueue中各个节点对应的题目规定值
            nodeQueue.offer(root);  // 入队
            numQueue.offer(root.val);  // 入队

            while (!nodeQueue.isEmpty()) {
                TreeNode currNode = nodeQueue.poll();  // 出队
                int currNum = numQueue.poll();  // 出队
                if (currNode.left == null && currNode.right == null) {  // 当前节点为叶子节点
                    ans += currNum;  // 遇到叶子节点 直接将结果加入到ans中
                } else {  // 当前节点不是叶子节点
                    // 扩展下一层的 待遍历节点 和 节点所对应的值
                    if (currNode.left != null) {
                        nodeQueue.offer(currNode.left);
                        numQueue.offer(currNum * 10 + currNode.left.val);
                    }
                    if (currNode.right != null) {
                        nodeQueue.offer(currNode.right);
                        numQueue.offer(currNum * 10 + currNode.right.val);
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}