//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
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
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量少于 4096 
// -1000 <= node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 355 👎 0

package com.glj.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode{
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
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

//    //leetcode submit region begin(Prohibit modification and deletion)
//    /*
//    // Definition for a Node.
//    class Node {
//        public int val;
//        public Node left;
//        public Node right;
//        public Node next;
//
//        public Node() {}
//
//        public Node(int _val) {
//            val = _val;
//        }
//
//        public Node(int _val, Node _left, Node _right, Node _next) {
//            val = _val;
//            left = _left;
//            right = _right;
//            next = _next;
//        }
//    };
//    */
//    // 法一：层次遍历法(广度优先遍历，借助队列)
//    // 算法思想：参考Problem102.二叉树的层次遍历的算法思想
//    //         在二叉树的层次遍历的基础上，改为：
//    //         在对每一层遍历时，记录上一个节点，如果当前节点不是最后一个节点，则让上一个节点的next指向当前节点；
//    //         如果当前节点是最后一个节点，则什么都不做(因为节点默认的next指向NULL)
//    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是N叉树的所有节点数
//    // 时间复杂度说明：每个节点入队和出队各一次
//    // 空间复杂度说明：这是一棵完美二叉树，它的最后一个层级包含N/2个节点。广度优先遍历的复杂度取决于一个层级上的最大元素数量。这种情况下空间复杂度为O(N)
//    // 参考资料1：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-ceng-xu-bian-li-deng-chang-wo-yao-da-sh/(二叉树层序遍历登场：我要打十个！)
//    class Solution {
//        public Node connect(Node root) {  // 这里的返回值为Node，应该返回根节点
//            if (root == null) {
//                return root;
//            }
//
//            Queue<Node> queue = new LinkedList<>();
//            queue.offer(root);  // 入队
//            while (!queue.isEmpty()) {
//                int currentLevelSize = queue.size();
//                for (int i = 0; i < currentLevelSize; i++) {
//                    Node node = queue.poll();
//                    // 这里可以巧妙运用queue.peek()函数
//                    // queue.element()与queue.peek()均用于查询队列头部元素，区别为：当队列为空
//                    // 时，queue.element()抛出异常，而queue.peek()返回null
//                    // node为当前节点，queue.peek()即为当前层的下一个节点或null
//                    if (i < currentLevelSize - 1) {  // 不是当前层的最后一个节点
//                        node.next = queue.peek();
//                    }
//                    // 拓展下一层的节点
//                    if (node.left != null) {
//                        queue.add(node.left);
//                    }
//                    if (node.right != null) {
//                        queue.add(node.right);
//                    }
//                }
//            }
//            return root;  // 返回根节点
//        }
//    }
//    //leetcode submit region end(Prohibit modification and deletion)

}