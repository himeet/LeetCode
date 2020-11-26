//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 116 👎 0
 
package com.glj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
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
    }
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
    // 法二：迭代法
    // 算法思想：使用一个栈来帮助我们得到前序遍历，需要保证栈顶的节点就是我们当前遍历到的节点
    //          (1)首先把跟节点入栈，因为根节点是前序遍历中的第一个节点
    //          (2)随后在每次循环中，我们从栈顶取出一个节点node，它是我们当前遍历到的节点
    //          (3)然后把node所有子节点逆序压入栈中(逆序的目的是为了保证出栈的顺序为前序遍历的顺序)
    // 时间复杂度：O(M)，空间复杂度：O(M) 其中N是N叉树中的节点个数
    // 时间复杂度说明：每个节点只入栈和出栈各一次
    // 空间复杂度说明：在最坏的情况下，这颗N叉树只有2层，所有第2层的节点都是根节点的孩子；将根节点出栈后，需要将剩余的M-1个节点全部压入栈中
    // 参考资料1：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/ncha-shu-de-qian-xu-bian-li-by-leetcode/(官方迭代法)
    // 参考资料2：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/yi-tao-quan-fa-shua-diao-nge-bian-li-shu-de-wen--3/(一套拳法刷多个遍历树的问题)
    // 参考资料3：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/che-di-chi-tou-qian-zhong-hou-xu-di-gui-fa-di-gui-/(彻底吃透前中后序递归和迭代[代码随想录])
    class Solution {
        public List<Integer> preorder(Node root) {
            // 返回的结果
            List<Integer> ans = new LinkedList<>();
            // 使用一个栈来帮助我们得到前序遍历，需要保证栈顶的节点就是我们当前遍历到的节点
            LinkedList<Node> stack = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            // (1)首先把跟节点入栈，因为根节点是前序遍历中的第一个节点
            stack.add(root);  // add()实现进栈操作
            while (!stack.isEmpty()) {
                // (2)随后在每次循环中，我们从栈顶取出一个节点node，它是我们当前遍历到的节点
                Node node = stack.pollLast();
                ans.add(node.val);
                // (3)然后把node所有子节点逆序压入栈中(逆序的目的是为了保证出栈的顺序为前序遍历的顺序)
                Collections.reverse(node.children);
                for (Node item : node.children) {
                    stack.add(item);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}