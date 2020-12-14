//给定一个二叉树 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 327 👎 0

package com.glj.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeIi{
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    */
    // 法二：使用已建立的next指针法
    // 算法思想：在法二中，本题与Problem116的差别为：
    //         (1)由于当前节点不一定存在孩子节点，所以循环结束的条件需要进行修改
    //         (2)在遍历第N层来给N+1层赋予next指针时，使用last来赋值
    //         (3)在遍历完当前层去遍历下一层的时候，
    //            最左边的节点不一定为leftMost = leftMost.left
    //            需要进行遍历当前层的节点找到最左边的一个孩子，即为leftMost
    // 时间复杂度：O(n)，空间复杂度：O(1)  其中n是N叉树的所有节点数
    // 时间复杂度说明：每个节点只访问一次
    // 空间复杂度说明：不需要存储额外的节点
    // 参考资料1：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-ceng-xu-bian-li-deng-chang-wo-yao-da-sh/(二叉树层序遍历登场：我要打十个！)
    // 参考资料2：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-15/(官方解)
    // 备注：这道题与Problem116的差别为此题中的二叉树不是完美二叉树，而Problem116中的二叉树为完美二叉树
    class Solution {
        public Node last = null;  // 在每一层中，last从头指到尾，层之间的节点能够构建连接，依靠于last节点
        public Node nextStart = null;  // nextStart标记下一层中的开始节点

        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Node start = root;  // start标记当前层的开始节点
            while (start != null) {
                last = null;
                nextStart = null;
                for (Node p = start; p != null; p = p.next) {  // p用于遍历当前层的节点
                    if (p.left != null) {  // 如果节点p有左孩子
                        handle(p.left);
                    }
                    if (p.right != null) { // 如果节点p有右孩子
                        handle(p.right);
                    }
                }
                start = nextStart;
            }
            return root;
        }

        /**
         * 若当前节点不为空，处理下一层节点的连接
         * @param pChild
         */
        public void handle(Node pChild) {
            // 在遍历每一层之前会将nextStart置为null，此语句会将nextStart赋值为下一层中的第一个孩子，可能是左孩子，也可能是右孩子
            // nextStart在被赋值后，在本次层级循环中，不会再次被赋值
            if (nextStart == null) {
                nextStart = pChild;
            }
            if (last != null) {
                last.next = pChild;
            }
            last = pChild;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}