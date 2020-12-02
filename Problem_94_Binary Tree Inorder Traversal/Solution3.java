//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 792 👎 0
 
package com.glj.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
    // 法三：Morris遍历法
    // 算法思想：“以某个根结点开始，找到它左子树的最右侧节点之后，与这个根结点进行连接”
    //           (省略)......
    // 时间复杂度：O(n)，空间复杂度：O(1)  其中n是二叉树的节点数
    // 时间复杂度说明：每一个节点恰好被遍历一次，共有n个节点
    // 空间复杂度说明：递归过程中栈的开销，平均情况下为O(logn)，最坏情况下树呈现链状，为O(n)
    // 参考资料1：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/(官方解)
    // 参考资料2：https://mp.weixin.qq.com/s/PwVIfxDlT3kRgMASWAMGhA(代码随想录-递归)
    // 参考资料3：https://mp.weixin.qq.com/s/c_zCrGHIVlBjUH_hJtghCg(代码随想录-迭代)
    // 参考资料4：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/(史上最全遍历二叉树详解)
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            TreeNode cur1 = root;  // 当前开始遍历的节点
            TreeNode cur2 = null;  // 记录当前节点的左子树
            while (cur1 != null) {
                cur2 = cur1.left;
                // 构建连接线
                if (cur2 != null) {
                    while (cur2.right != null && cur2.right != cur1) {
                        cur2 = cur2.right;
                    }
                    if (cur2.right == null) {  //这个时候如果最右侧这个节点的右指针没有指向根结点，创建连接然后往下一个左子树的根结点进行连接操作。
                        cur2.right = cur1;
                        cur1 = cur1.left;
                        continue;
                    } else {  //当左子树的最右侧节点有指向根结点，此时说明我们已经回到了根结点并重复了之前的操作，同时在回到根结点的时候我们应该已经处理完 左子树的最右侧节点 了，把路断开。
                        cur2.right = null;
                    }
                }
                ans.add(cur1.val);
                cur1 = cur1.right;  //一直往右边走，参考图
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}