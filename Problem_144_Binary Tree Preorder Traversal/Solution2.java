//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 463 👎 0
 
package com.glj.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

   //leetcode submit region begin(Prohibit modification and deletion)
   /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode() {}
    *     TreeNode(int val) { this.val = val; }
    *     TreeNode(int val, TreeNode left, TreeNode right) {
    *         this.val = val;
    *         this.left = left;
    *         this.right = right;
    *     }
    * }
    */
   // 法二：迭代法
   // 算法思想：用迭代的方式实现方法一的递归函数，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，
   //          而我们在迭代的时候需要显式地将这个栈模拟出来，其余的实现与细节都相同。
   //          注意为了满足“根左右”的顺序，右子树先进栈，左子树再进栈
   // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
   // 时间复杂度说明：每一个节点恰好被遍历一次，共有n个节点
   // 空间复杂度说明：递归过程中栈的开销，平均情况下为O(logn)，最坏情况下树呈现链状，为O(n)
   // 参考资料1：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/(官方解)
   // 参考资料2：https://mp.weixin.qq.com/s/PwVIfxDlT3kRgMASWAMGhA(代码随想录-递归)
   // 参考资料3：https://mp.weixin.qq.com/s/c_zCrGHIVlBjUH_hJtghCg(代码随想录-迭代)
   // 参考资料4：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/(史上最全遍历二叉树详解)
   class Solution {
       public List<Integer> preorderTraversal(TreeNode root) {
           List<Integer> ans = new LinkedList<>();
           if (root == null) {
               return ans;
           }
           // 使用queue模拟一个stack
           Deque<TreeNode> stack = new LinkedList<>();
           // Stack<TreeNode> stack = new Stack<>();
           stack.push(root);  // 模拟进栈
           while (!stack.isEmpty()) {
               TreeNode node = stack.pop();  // node为当前子树的根
               ans.add(node.val);  // 出栈，即遍历栈顶元素
               if (node.right != null) {
                   stack.push(node.right);
               }
               if (node.left != null) {
                   stack.push(node.left);
               }
           }
           return ans;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}