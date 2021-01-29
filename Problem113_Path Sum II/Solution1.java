//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 402 👎 0

package com.glj.leetcode.editor.cn;

import java.util.*;

public class PathSumIi{
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.right = null;
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left =  new TreeNode(7);
        root.left.left.right =  new TreeNode(2);
        root.right.right.left =  new TreeNode(5);
        root.right.right.right =  new TreeNode(1);
        List<List<Integer>> ans = solution.pathSum(root, 22);
        System.out.println(ans);
    }
    public static class TreeNode {
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
   // 法一：深度优先搜索
   // 算法思想：(1)确定递归函数的参数和返回值
   //         (2)确定终止条件
   //         (3)确定单层递归的逻辑
   // 时间复杂度：O(n^2)，空间复杂度：O(n)  其中n是二叉树的节点数
   // 时间复杂度说明：在最坏情况下，树的上半部分为链状，下半部分为完全二叉树，并且从根节点到每一个叶子节点的路径都符合题目要求。
   //             此时，路径的数目为O(n)，并且每一条路径的节点个数也为O(n)，因此要将这些路径全部添加进答案中，时间复杂度为O(n^2)
   // 空间复杂度说明：空间复杂度主要取决于栈空间的开销，栈中的元素个数不会超过树的节点数
   // 参考资料1：https://mp.weixin.qq.com/s/6TWAVjxQ34kVqROWgcRFOg(代码随想录公众号)
   // 参考资料2：https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/(官方解)
   class Solution {
       private Deque<Integer> path = new LinkedList<Integer>();

       public List<List<Integer>> pathSum(TreeNode root, int sum) {
           List<List<Integer>> ans = new LinkedList<>();
           if (root == null) {
               return ans;  // 空节点不遍历
           }
           this.path.offerLast(root.val);  // 别忘了把根节点放入path中！！
           dfs(root, sum - root.val, ans);
           return ans;
       }

       /**
        * 查找二叉树中所有满足条件的路径 递归
        * @param root
        * @param sum
        * @param ans
        */
       // 不允许叶子节点的子节点（空节点）进入递归
       // 递归函数不需要返回值，因为我们要遍历整个树
       public void dfs(TreeNode root, int sum, List<List<Integer>> ans) {
           // 确定递归中止条件1
           if (root.left == null && root.right == null && sum != 0) {  // 遇到叶子节点而没有找到合适的边，直接返回
               return;
           }
           // 确定递归中止条件2
           if (root.left == null && root.right == null && sum == 0) { // 遇到了叶子节点并且找到了和为sum的路径
               ans.add(new LinkedList<>(this.path));
               return;
           }
           // 确定单层递归的逻辑
           if (root.left != null) {  // 左 （空节点不遍历）
               this.path.offerLast(root.left.val);
               sum -= root.left.val;
               dfs(root.left, sum, ans);  // 递归
               sum += root.left.val;      // 回溯
               this.path.pollLast();// 回溯
           }
           if (root.right != null) {  // 左 （空节点不遍历）
               this.path.offerLast(root.right.val);
               sum -= root.right.val;
               dfs(root.right, sum, ans);  // 递归
               sum += root.right.val;      // 回溯
               this.path.pollLast();// 回溯
           }
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}