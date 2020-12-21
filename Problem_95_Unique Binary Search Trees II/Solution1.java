//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 733 👎 0

package com.glj.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesIi{
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
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
    // 法一：递归法
    // 算法思想：见题解
    // 时间复杂度：O(4^n / n^1/2)，空间复杂度：O(4^n / n^1/2)  其中n是二叉树的节点数
    // 时间复杂度说明：见题解
    // 空间复杂度说明：见题解
    // 参考资料1：https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/(官方解）
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> ans = new LinkedList<>();  // 返回的结果
            if (n == 0) {  // 0 <= n <= 8 所以需要考虑n=0的情况
                return ans;
            }
            return generateTrees(1, n);
        }

        /**
         * 生成Trees
         * @param start
         * @param end
         * @return
         */
        public List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> allTrees = new LinkedList<>();
            if (start > end) {  // 递归结束的条件
                allTrees.add(null);
                return allTrees;
            }

            // 枚举可行根节点
            for (int i = start; i <= end; i++) {
                // 获得所有可行的左子树集合
                List<TreeNode> leftTrees = generateTrees(start, i - 1);
                // 获得所有可行的右子树集合
                List<TreeNode> rightTrees = generateTrees(i + 1, end);
                // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode currTree = new TreeNode(i);
                        currTree.left = left;
                        currTree.right = right;
                        allTrees.add(currTree);
                    }
                }

            }
            return allTrees;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}