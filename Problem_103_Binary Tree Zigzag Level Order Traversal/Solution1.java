//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 361 👎 0

package com.glj.leetcode.editor.cn;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    // 法一：广度优先遍历法
    // 算法思想：（1）参照Problem102.二叉树的层序遍历，在此基础上，在对每层遍历时，不再使用一个List存储层结果level，
    //             而是使用一个双端队列来存储层结果level；
    //         （2）同时需要设置一个flag isOrderLeft来标识当前层的遍历顺序是否为从左开始（从左到右）；
    //         （3）若isOrderLeft==true，则插入双端队列的尾部；若isOrderLeft==false，则插入双端队列的头部。
    //            （插入尾部是左边的元素先进先出，插入头部的是左边的元素先进后出）
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n表示二叉树的节点个数
    // 时间复杂度说明：每个节点会且仅会被遍历一次
    // 空间复杂度说明：需要维护存储节点的队列和存储节点值的双端队列
    // 参考资料1：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/er-cha-shu-de-ju-chi-xing-ceng-xu-bian-l-qsun/(官方解)
    // 备注1：最普通的层次遍历的解法参照Problem102
    // 备注2：深度优先遍历法未看
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);  // 入队
            boolean isOrderLeft = true;  // 标识当前层的遍历顺序，是否为从左开始

            while (!queue.isEmpty()) {
                Deque<Integer> level = new LinkedList<>();  // 使用双端队列来存储当前层的节点val
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {  // 对队列中的元素进行遍历
                    TreeNode node = queue.poll();  // 出队
                    if (isOrderLeft) {
                        level.offerLast(node.val);
                    } else {
                        level.offerFirst(node.val);
                    }
                    // 拓展下一层的节点
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ans.add(new LinkedList<Integer>(level));  // 将每一层的结果转为List存入ans中
                isOrderLeft = !isOrderLeft;  // 遍历完一层后，将isOrderLeft置反
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}