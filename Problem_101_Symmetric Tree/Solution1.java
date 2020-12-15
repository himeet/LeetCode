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
   // 法一：递归法-2.0
   // 算法思想：(1)分析题目可知，如果一个树的左子树和右子树镜像对称，那么这个树是对称的
   //            如果同时满足以下两个条件，两个树互为镜像：
   //            条件一：它们的两个根结点具有相同的值
   //            条件二：每个树的右子树都与另一个树的左子树镜像对称
   //         (2)我们可以实现一个这样一个递归函数，通过同步移动两个指针来遍历这棵树，p指针和q指针一开始都指向这棵树的根，
   //            随后p右移时，q左移；p左移时，q右移。每次检查当前p和q节点的值是否相等，如果相等再判断左右子树是否对称
   // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
   // 时间复杂度说明：遍历了这棵树的所有节点
   // 空间复杂度说明：空间复杂度和递归使用的栈空间有关，这里递归层数不超过n
   // 参考资料1：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/(官方解)
   // 参考资料2：https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
   class Solution {
       public boolean isSymmetric(TreeNode root) {
           if (root == null) {
               return true;
           }
           return check(root.left, root.right);
       }
       public boolean check(TreeNode left, TreeNode right) {
           // 递归的终止条件是两个节点都为空
           // 或者两个节点中有一个为空
           // 或者两个节点的值不相等
           // 第一个if判断一定要放在第二个if判断前
           if (left == null && right == null) {  // p和q同时为空，说明此时遍历完整棵树，递归结束的条件
               return true;
           }
           if (left == null || right == null) { // p和q中，其中一个为空，另一个不为空。在递归过程中产生该情况说明不对称
               return false;
           }
           if (left.val != right.val) {
               return false;
           }
           // 再递归的比较 左节点的左孩子 和 右节点的右孩子
           // 以及比较 左节点的右孩子 和 右节点的左孩子
           return check(left.left, right.right) && check(left.right, right.left);
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}