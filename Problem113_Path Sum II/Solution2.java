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
    // 法二：广度优先搜索
    // 算法思想：
    // 时间复杂度：O(n^2)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：在最坏情况下，树的上半部分为链状，下半部分为完全二叉树，并且从根节点到每一个叶子节点的路径都符合题目要求。
    //             此时，路径的数目为O(n)，并且每一条路径的节点个数也为O(n)，因此要将这些路径全部添加进答案中，时间复杂度为O(n^2)
    // 空间复杂度说明：空间复杂度主要取决于哈希表和队列空间的开销，哈希表需要存储除根节点外的每个节点的父节点，队列中的元素个数不会超过树的节点数。
    // 参考资料1：https://leetcode-cn.com/problems/path-sum-ii/solution/3chong-fang-shi-jie-jue-2chong-ji-bai-liao-100de-2/
    // 参考资料2：https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/(官方解)
    // 注意：广度优先搜索时，不能使用sum -= val然后判断最终到达叶子节点是否等于0这种方式，因为这个时候sum对于左右两条路径是全局变量，
    //      单条路径中sum的改变会影响另一条路径中的判断；应该使用每条路径将当前node的val叠加到下一层孩子节点val上，最终判断叶子节点
    //      的val是否等于sum的方式
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            //使用两个队列，一个存储结点，一个存储从根结点到当前节点的路径
            Queue<TreeNode> queueNode = new LinkedList<>();  // 存储结点
            Queue<List<Integer>> queuePath = new LinkedList<>();  // 存储从根节点到当前节点的路径
            // 根节点入队
            queueNode.add(root);
            // 根节点的路径入队
            List<Integer> list =  new ArrayList<>();
            list.add(root.val);
            queuePath.add(list);
//            sum -= root.val;  // 广度优先遍历不能使用sum-=val该方式

            while (!queueNode.isEmpty()) {
                // 当前节点出队
                TreeNode node = queueNode.poll();
                // 当前节点的路径出队
                List<Integer> tmpPath = queuePath.poll();
                if (node.left == null && node.right == null && node.val == sum) {
                    // 如果满足条件，就把路径存储到ans中
                    ans.add(tmpPath);
                }
                // 左子节点不为空，左子节点和路径入队
                if (node.left != null) {
                    tmpPath.add(node.left.val);
                    queuePath.add(new LinkedList<>(tmpPath));
//                    queuePath.add(tmpPath);  // 错误方式，应该用上面那种方式

//                    sum -= node.left.val;  // 广度优先遍历不能使用sum-=val该方式
                    node.left.val += node.val;

                    queueNode.add(node.left);  // 此时node.left的val已经是 原来的node.left.val + node.val了，这样用来判断是否等于sum

                    tmpPath.remove(tmpPath.size() - 1);  // 从tmpPath中移除的目的是下面右子节点部分还要用未被污染的tmpPath
                }
                // 右子节点不为空，右子节点和路径入队
                if (node.right != null) {
                    tmpPath.add(node.right.val);
                    queuePath.add(new LinkedList<>(tmpPath));
//                    queuePath.add(tmpPath);  // 错误方式，应该用上面那种方式

                    node.right.val += node.val;

//                    sum -= node.right.val;  // 广度优先遍历不能使用sum-=val该方式
                    queueNode.add(node.right);  // 此时node.right 原来的node.right.val + node.val了，这样用来判断是否等于sum
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}