//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 655 👎 0

package com.glj.leetcode.editor.cn;

public class ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 法一：中序遍历，总是选择中间位置左边的数字作为根节点
    // 算法思想：(1)二叉搜索树的中序遍历是升序序列，题目给定的数组是按照升序排序的有序数组，因此可以确保数组是二叉搜索树的中序遍历序列；
    //         (2)给定二叉搜索树的中序遍历，不可以唯一地确定二叉搜索树；增加一个限制条件：要求二叉搜索树的高度平衡，也不可以唯一确定；
    //         (3)直观地看，我们可以选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差1，可以使得树保持平衡，
    //            如果数组长度是奇数，则根节点的选择是唯一的，如果数组长度是偶数，则可以选择中间位置左边的数字作为根节点或者选择中间
    //            位置右边的数字作为根节点，选择不同的数字作为根节点则创建的平衡二叉搜索树也是不同的；
    //         (4)确定平衡二叉搜索树的根节点之后，其余的数字分别位于平衡二叉搜索树的左子树和右子树中，左子树和右子树分别也是平衡二叉
    //            搜索树，因此可以通过递归的方式创建平衡二叉搜索树；
    //         (5)递归的基准情形是平衡二叉搜索树不包含任何数字，此时平衡二叉搜索树为空；
    //         (6)在给定中序遍历序列数组的情况下，每一个子树中的数字在数组中一定是连续的，因此可以通过数组下标范围确定子树包含的数字，
    //            下标范围记为[left, right]，对于整个中序遍历序列，下标范围从left=0到right=nums.length-1，当left>right时，
    //            平衡二叉搜索树为空。
    //          (7)选择中间位置左边的数字作为根节点，则根节点的下标为mid=(left+right)/2
    // 时间复杂度：O(n)，空间复杂度：O(logn)  其中n是数组的长度
    // 时间复杂度说明：每个数字只访问一次
    // 空间复杂度说明：空间复杂度不考虑返回值，因此空间复杂度主要取决于递归栈的深度，递归栈的深度是O(logn)
    // 参考资料1：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/(官方解)
    // 备注1：甜姨の分析：BST的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树。因此我们可以以升序序列中的任一个元素作为
    //     根节点，以该元素左边的升序序列构建左子树，以该元素右边的升序序列构建右子树，这样得到的树就是一棵二叉搜索树啦～ 又因为本题要求
    //     高度平衡，因此我们需要选择升序序列的中间元素作为根节点奥～
    // 备注2：法二和法三在本解法代码的注释中
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        /**
         * 递归调用函数
         * @param nums
         * @param left
         * @param right
         * @return
         */
        public TreeNode helper(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            // 总是选择中间位置左边的数字作为根节点
            int mid = (left + right) / 2;
            // 法二：中序遍历，总是选择中间位置右边的数字作为根节点
            // int mid = (left + right + 1) / 2;
            // 法三：中序遍历，选择任意一个中间位置数字作为根节点
            // int mid = (left + right + rand.nextInt(2)) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, left, mid - 1);
            root.right = helper(nums, mid + 1, right);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}