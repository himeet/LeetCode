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
    // 算法思想：分析：一棵树中，存在两种类型的next指针：
    //             (1)第一种情况是：连接到同一个父节点的两个子节点，它们可以通过同一个节点访问到，执行如下操作即可node.left.next = node.right
    //             (2)第二种情况是：在不同父亲的子节点之间建立连接，这种情况不能直接连接。大致思想为：
    //                在第N层的节点之间建立next指针后，使用第N层的next指针为第N+1层的节点建立next指针
    //         算法：(1)从根节点开始，由于第0层只有一个节点，所以不需要连接，直接为第1层节点建立next指针即可
    //              该算法中需要注意的一点是，当我们为第N层节点建立next指针时，处于第N-1层。当第N层节点的next指针全部建立完成后，移至第N层，建立第N+1层节点的next指针
    //              (2)遍历某一层的节点时，这层节点的next指针已经建立，因此我们只需要知道这一层的最左节点，就可以按照链表方式遍历，不需要使用队列
    //              (3)对于两种类型的next指针：第一种情况，两个子节点属于同一个父节点，因此通过父节点建立两个子节点的next指针即可：node.left.next=node.right
    //                 第二种情况，在不同父亲的子节点之间建立连接，更具体地说，连接的是第一个父节点的右孩子和第二个父节点的左孩子。由于已经在父节点这层建立了next指针，
    //                 因此可以直接通过第一个父节点的next指针找到第二个父节点，然后在他们的孩子之间建立连接：node.right.next = node.next.left
    //              (4)完成当前层的连接后，进入下一层重复操作，直到所有的节点全部连接。进入下一层后需要更新最左节点，然后从新的最左节点开始遍历该层所有节点。
    //                 因为是完美二叉树，因此最左节点一定是当前层最左节点的左孩子。如果当前最左节点的左孩子不存在，说明已经到达该树的最后一层，完成了所有节点的连接。
    // 时间复杂度：O(n)，空间复杂度：O(1)  其中n是N叉树的所有节点数
    // 时间复杂度说明：每个节点只访问一次
    // 空间复杂度说明：不需要存储额外的节点
    // 参考资料1：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-ceng-xu-bian-li-deng-chang-wo-yao-da-sh/(二叉树层序遍历登场：我要打十个！)
    // 参考资料2：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/(官方解)
    class Solution {
        public Node connect(Node root) {  // 这里的返回值为Node，应该返回根节点
            if (root == null) {
                return root;
            }

            // 从根节点开始
            Node leftMost= root;  // 标记最左节点
            while (leftMost.left != null) {  // leftMost.left == null时，说明此时处于叶子层  // 遍历每一层
                // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
                Node head = leftMost;
                while (head != null) {  // 遍历当前层的节点
                    // 连接1
                    head.left.next = head.right;
                    // 连接2
                    if (head.next != null) {  // 如果不是当前层的最后一个节点
                        head.right.next = head.next.left;
                    }
                    // 指针向后移动
                    head = head.next;
                }
                // 去下一层的最左节点
                leftMost = leftMost.left;
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}