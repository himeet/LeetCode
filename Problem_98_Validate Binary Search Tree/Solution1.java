//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 866 👎 0

package com.glj.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
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

//    //leetcode submit region begin(Prohibit modification and deletion)
//    // 法一：递归法
//    // 算法思想：见官方解
//    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n表示二叉树的节点个数
//    // 时间复杂度说明：在递归调用的时候二叉树的每个节点最多被访问一次
//    // 空间复杂度说明：递归函数在递归过程中需要为每一层递归函数分配栈空间，所以这里需要额外
//    //             的空间且该空间取决于递归的深度，即二叉树的高度。最坏情况下二叉树为一条
//    //             链，树的高度为n，递归最深达到n层
//    // 参考资料1：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/(官方解)
//    // 备注1：是根据官方解改动的版本
//    // 备注2：改动的代码有一个坑，当该树只有一个结点值为 Integer.MIN_VALUE或Integer.MAX_VALUE时，
//    //       在进行递归的时候，就会进入第二个if判断，返回false，但是其实应该为true的。解决方法为：在
//    //       给helper函数的初始输入时，放入Long.MIN_VALUE和Long.MAX_VALUE
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode() {}
//     *     TreeNode(int val) { this.val = val; }
//     *     TreeNode(int val, TreeNode left, TreeNode right) {
//     *         this.val = val;
//     *         this.left = left;
//     *         this.right = right;
//     *     }
//     * }
//     */
//    class Solution {
//        public boolean isValidBST(TreeNode root) {
//            // Integer.MAX_VALUE为0x7fffffff即2147483647
//            // 当给helper函数传入2147483647这个测试用例时，会出现误判的情况
//            // Integer.MIN_VALUE同理
//            // 所以这里需要改为Long
//            // return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
//        }
//
//        /**
//         * 判断是否符合二叉搜索树的条件 递归
//         * @param root
//         * @param lower
//         * @param upper
//         * @return
//         */
//        public boolean helper(TreeNode root, long lower, long upper) {  // 相应地，这里也要改为long
//            // 递归结束的条件，到达根节点还未出现false情况，则返回true
//            if (root == null) {
//                return true;
//            }
//
//            int rootVal = root.val;
//            if (rootVal <= lower) {  // 注意这里是<=，因为二叉搜索树左子树的值是绝对小于根节点的值
//                return false;
//            }
//            if (rootVal >= upper) {  // 注意这里是>=，因为二叉搜索树右子树的值是绝对大于根节点的值
//                return false;
//            }
//            // 递归判断左子树是否满足条件
//            if (!helper(root.left, lower, rootVal)) {
//                return false;
//            }
//            // 递归判断右子树是否满足条件
//            if (!helper(root.right, rootVal, upper))  {
//                return false;
//            }
//
//            return true;
//        }
//    }
//    //leetcode submit region end(Prohibit modification and deletion)

}