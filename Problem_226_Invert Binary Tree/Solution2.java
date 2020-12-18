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
   // 法二：递归法(从上到下)(王尼玛の解，好理解)
   // 算法思想：(1)终止条件：当前节点为null时返回
   //         (2)交换当前节点的左右节点，再递归的交换当前节点的左节点，递归的交换当前节点的右节点
   // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
   // 时间复杂度说明：我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树
   // 空间复杂度说明：使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。在平均情况下，二叉树的
   //             高度与节点个数为对数关系，即O(logN);而在最坏情况下，树形成链状，空间复杂度为O(N)。
   // 参考资料1：https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode-solution/(官方解)
   // 参考资料2：https://leetcode-cn.com/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/(王尼玛の题解)
   // 备注：递归法即为深度优先遍历
   class Solution {
       public TreeNode invertTree(TreeNode root) {
           // 递归函数的终止条件，节点为空时返回
           if(root==null) {
               return null;
           }
           // 下面三句是将当前节点的左右子树的根交换
           TreeNode tmp = root.right;
           root.right = root.left;
           root.left = tmp;

           // 递归交换当前节点的 左子树
           invertTree(root.left);
           // 递归交换当前节点的 右子树
           invertTree(root.right);

           // 函数返回时就表示当前这个节点，以及它的左右子树
           // 都已经交换完了
           return root;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}