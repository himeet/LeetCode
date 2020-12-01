//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 483 👎 0
 
package com.glj.leetcode.editor.cn;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
	// 算法思想：(1)用迭代的方式实现方法一的递归函数，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，
	//             而我们在迭代的时候需要显式地将这个栈模拟出来，其余的实现与细节都相同。
	//          (2)注意为了要实现“左->右->根”的顺序，我们让节点按照“左->右”的顺序进栈，那么出栈顺序就为“右->左”，那么遍历的顺序就为“根->右->左”，
	//             再将该结果数组反转一下即为“左->右->根”，实现了后续遍历的顺序。
	// 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
	// 时间复杂度说明：每一个节点恰好被遍历一次，共有n个节点
	// 空间复杂度说明：递归过程中栈的开销，平均情况下为O(logn)，最坏情况下树呈现链状，为O(n)
	// 参考资料1：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode-solution/(官方解)
	// 参考资料2：https://mp.weixin.qq.com/s/PwVIfxDlT3kRgMASWAMGhA(代码随想录-递归)
	// 参考资料3：https://mp.weixin.qq.com/s/c_zCrGHIVlBjUH_hJtghCg(代码随想录-迭代)
	// 参考资料4：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/(史上最全遍历二叉树详解)
	class Solution {
	   public List<Integer> postorderTraversal(TreeNode root) {
	       List<Integer> ans = new LinkedList<>();
	       if (root == null) {
	           return ans;
	       }
	       // 使用双端queue模拟一个栈
	       Deque<TreeNode> stack = new LinkedList<>();
	       stack.push(root);  // 进栈
	       while (!stack.isEmpty()) {
	           TreeNode node = stack.pop();
	           ans.add(node.val);
	           if (node.left != null) {
	               stack.push(node.left);
	           }
	           if (node.right != null) {
	               stack.push(node.right);
	           }
	       }
	       // 将结果反转即为后序遍历
	       Collections.reverse(ans);
	       return ans;
	   }
	}
	//leetcode submit region end(Prohibit modification and deletion)

}