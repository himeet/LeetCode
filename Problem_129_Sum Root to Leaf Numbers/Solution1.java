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
   // 法一：深度优先遍历法
   // 算法思想：（1）二叉树的每条从根节点到叶子节点的路径都代表一个数字。其实，每个节点都对应
   //             一个数字，等于其父节点对应的数字乘以10再加上该节点的值；
   //         （2）深度优先遍历：从根节点开始，遍历每个节点，如果遇到叶子节点，则将叶子节点
   //             对应的数字加到数字之和。如果当前节点不是叶子节点，则计算其子节点对应的数
   //             字，然后对子节点递归遍历
   // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
   // 时间复杂度说明：对每个节点访问一次
   // 空间复杂度说明：空间复杂度主要取决于递归调用的栈空间，递归栈的深度等于二叉树的高度，最坏情
   //              况下，二叉树的高度等于节点个数，空间复杂度为O(n)
   // 参考资料1：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/(官方解)
   // 参考资料2：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/129-qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-di-4/(代码随想录)
   class Solution {
       public int sumNumbers(TreeNode root) {
           if (root == null) {  // 空节点不进入递归
               return 0;
           }
           return dfs(root, 0);
       }

       /**
        * 求二叉树的所有节点和 递归
        * @param root
        * @param preSum
        * @return
        */
       public int dfs(TreeNode root, int preSum) {  // 空节点不进入递归
           int currSum = preSum * 10 + root.val;

           // 递归的中止条件
           if (root.left == null && root.right == null) {  // 如果已经到达叶子节点，返回当前的和
               return currSum;
           }

           // 确定递归的单层逻辑
           int nextLeftSum = 0;
           if (root.left != null) {
               nextLeftSum = dfs(root.left, currSum);
           }
           int nextRightSum = 0;
           if (root.right != null) {
               nextRightSum = dfs(root.right, currSum);
           }
           return nextLeftSum + nextRightSum;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}