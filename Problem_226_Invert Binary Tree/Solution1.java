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
   // 法一：递归法(从下到上)(官方解，不好理解)
   // 算法思想：(1)我们从根节点开始，递归地对树进行遍历，并从叶子结点先开始翻转;
   //         (2)如果当前遍历到的节点root的左右两棵子树都已经翻转，那么我们只需要交换两棵子树的位置，
   //            即可完成以root为根节点的整棵子的翻转。
   // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
   // 时间复杂度说明：我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树
   // 空间复杂度说明：使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。在平均情况下，二叉树的
   //             高度与节点个数为对数关系，即O(logN);而在最坏情况下，树形成链状，空间复杂度为O(N)。
   // 参考资料1：https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode-solution/(官方解)
   // 参考资料2：https://leetcode-cn.com/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/(王尼玛の题解)
   class Solution {
       public TreeNode invertTree(TreeNode root) {
           // 递归结束的条件
           if (root == null) {
               return root;
           }
           // 想一下最基本的情况，root只有一个左孩子和一个右孩子
           // 先翻转叶子，然后交换root的左右子树
           // 翻转叶子
           TreeNode left = invertTree(root.left);
           TreeNode right = invertTree(root.right);
           // 交换root的左右子树
           root.left = right;
           root.right = left;
           return root;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}