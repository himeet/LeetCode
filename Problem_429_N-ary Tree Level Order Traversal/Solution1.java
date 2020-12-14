//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 
// 👍 120 👎 0

package com.glj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    */
    // 法一：广度优先搜索法(借助队列)
    // 算法思想：参考Problem102.二叉树的层次遍历的算法思想
    //         在二叉树的层次遍历的基础上，改为：每个节点有多个孩子节点，将多个孩子都需要加入队列
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是N叉树的所有节点数
    // 时间复杂度说明：每个节点入队和出队各一次
    // 空间复杂度说明：队列中节点数不会超过n
    // 参考资料1：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-ceng-xu-bian-li-deng-chang-wo-yao-da-sh/(二叉树层序遍历登场：我要打十个！)
    // 参考资料2：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/(官方解)
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);  // 入队
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    Node node = queue.poll();  // 出队
                    level.add(node.val);
                    for (Node child : node.children) {  // 将所有的孩子节点加入队列
                        queue.offer(child);
                    }
                    // 这里也可以不用for循环遍历，直接使用以下方式：
                    // queue.addAll(node.children);
                }
                ans.add(level);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}