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
	// 法一：递归法
	// 算法思想：若N叉树为空，则什么都不做；
	//          若N叉树不为空，则(1)访问根节点 (2)前序遍历children[0]...children[-1]
	// 时间复杂度：O()，空间复杂度：O()
	// 时间复杂度说明：不会计算时间复杂度(待补充)
	// 空间复杂度说明：不会计算空间复杂度(待补充)
	// 参考资料1：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/ncha-shu-de-qian-xu-bian-li-by-leetcode/(评论)
	// 参考资料2：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/yi-tao-quan-fa-shua-diao-nge-bian-li-shu-de-wen--3/(一套拳法刷多个遍历树的问题)
	// 参考资料3：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/che-di-chi-tou-qian-zhong-hou-xu-di-gui-fa-di-gui-/(彻底吃透前中后序递归和迭代[代码随想录])
	class Solution {
	   public List<Integer> preorder(Node root) {
	       List<Integer> ans = new ArrayList<>();
	       preOrderNTree(root, ans);
	       return ans;
	   }

	   /**
	    * 前序遍历N叉树
	    * @param root
	    * @param ans
	    */
	   public void preOrderNTree(Node root, List<Integer> ans) {
	       // 递归结束的边界
	       if (root == null) {
	           return;
	       }
	       // 访问根节点，获取根节点的值
	       ans.add(root.val);
	       // 前序遍历根节点的所有子树
	       for (Node node : root.children) {
	           preOrderNTree(node, ans);
	       }
	   }
	}
	//leetcode submit region end(Prohibit modification and deletion)

}