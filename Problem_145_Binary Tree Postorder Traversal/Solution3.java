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
    // 法三：Morris遍历法
    // 算法思想：“以某个根结点开始，找到它左子树的最右侧节点之后，与这个根结点进行连接”
    //          Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减。其后序遍历规则总结如下：
    //          (1)新建临时节点，令该节点为root；
    //          (2)如果当前节点的左子节点为空，则遍历当前节点的右子节点；
    //          (3)如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点：
    //             (3-1)如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点，当前节点更新为当前节点的左子节点；
    //             (3-2)如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。倒序输出从当前节点的左子节点到该前驱节点这条路径上的所有节点。
    //                  当前节点更新为当前节点的右子节点；
    //          (4)重复步骤2和步骤3，直到遍历结束。
    // 时间复杂度：O(n)，空间复杂度：O(1)  其中n是二叉树的节点数
    // 时间复杂度说明：没有左子树的节点只被访问一次，有左子树的节点被访问两次
    // 空间复杂度说明：只操作已经存在的指针（树的空闲指针），因此只需要常数的额外空间
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
            TreeNode cur1 = root;  // 遍历树的指针变量
            TreeNode cur2 = null;  // 当前子树的最右节点
            while (cur1 != null) {
                cur2 = cur1.left;
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
                        saveRet(cur1.left, ans);
                    }
                }
                cur1 = cur1.right;  //一直往右边走，参考图
            }
            saveRet(root, ans);
            return ans;
        }

        /**
         * 将结果保存到ans中
         * @param root
         * @param ans
         */
        public void saveRet(TreeNode root, List<Integer> ans) {
            TreeNode reverseList = reverseList(root);
            TreeNode cur = reverseList;
            while (cur != null) {
                ans.add(cur.val);
                // System.out.print(cur.val + " ");
                cur = cur.right;
            }
            reverseList(reverseList);
        }

        /**
         * 翻转单链表
         * @param root
         * @return
         */
        public TreeNode reverseList(TreeNode root) {
            TreeNode cur = root;
            TreeNode pre = null;
            while (cur != null) {
                TreeNode next = cur.right;
                cur.right = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}