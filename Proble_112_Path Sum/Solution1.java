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
   // 法一：递归（深度优先搜索法）
   // 算法思想：（1）确定递归函数的参数和返回值
   //             确定参数：需要二叉树的根节点，还需要一个计数器，这个计数器用来计算二叉树的一条边之和是否正好是
   //                     目标和，计数器为int型
   //             确定返回值：如果需要搜索整颗二叉树才能得到结果，那么递归函数就不要返回值，如果要搜索其中一条符
   //                      合条件的路径就能得到结果，递归函数就需要返回值，因为遇到符合条件的路径了就要及时返回
   //         （2）确定终止条件：计数器初始为count，然后每次减去节点上的值
   //                        若最后count==0，同时达到了叶子节点的话，就说明找到了目标和
   //                        若遍历到了叶子节点，count不为0的话（可能大于0可能小于0），就是没找到目标和
   //         （3）确定单层递归的逻辑：因为终止条件是判断叶子节点，所以递归的过程中就不要让空节点进入递归了
   //                             递归函数是有返回值的，如果递归函数返回true，说明找到了合适的路径，应该立刻返回。
   // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
   // 时间复杂度说明：对每个节点访问一次
   // 空间复杂度说明：空间复杂度主要取决于递归调用的栈空间，递归栈的深度等于二叉树的高度，最坏情
   //              况下，二叉树的高度等于节点个数，空间复杂度为O(n)
   // 参考资料1：https://mp.weixin.qq.com/s/6TWAVjxQ34kVqROWgcRFOg(代码随想录公众号)
   // 参考资料2：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/(官方解)
   class Solution {
       public boolean hasPathSum(TreeNode root, int sum) {
           if (root == null) {  // 不让空节点进入递归
               return false;
           }
           return dfs(root, sum - root.val);  // 注意这里初值的设置！！
       }

       /**
        *  查找二叉树中是否存在一条满足条件的路径 递归
        * @param root
        * @param counter
        * @return
        */
       public boolean dfs(TreeNode root, int counter) {
           // 递归中止条件1  若最后count==0，同时达到了叶子节点的话，就说明找到了目标和
           if (root.left == null && root.right == null && counter == 0) {
               return true;
           }
           // 递归中止条件2 若遍历到了叶子节点，count不为0的话（可能大于0可能小于0），就是没找到目标和
           if (root.left == null && root.right == null && counter != 0) {
               return false;
           }

           // 确定单层递归的逻辑
           if (root.left != null) {  // 不让空节点进入递归
               counter -= root.left.val;  // 计数器减1。注意！！这里不是减去root.val，因为本函数的第一句的counter == 0
               if (dfs(root.left, counter)) {  // 这里隐藏着回溯（函数结束后，counter的值没改变）
                   return true;
               }
               counter += root.left.val;  // 回溯，撤销处理结果
           }
           if (root.right != null) {
               counter -= root.right.val;
               if (dfs(root.right, counter)) {  // 这里隐藏着回溯
                   return true;
               }
               counter += root.right.val;
           }
           return false;
       }

   }
   //leetcode submit region end(Prohibit modification and deletion)

}