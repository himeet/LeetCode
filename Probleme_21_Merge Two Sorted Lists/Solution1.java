//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1551 👎 0

package com.glj.leetcode.editor.cn;

public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

   //leetcode submit region begin(Prohibit modification and deletion)
   /**
    * Definition for singly-linked list.
    * public class ListNode {
    *     int val;
    *     ListNode next;
    *     ListNode() {}
    *     ListNode(int val) { this.val = val; }
    *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    * }
    */
   // 法一：递归法
   // 算法思想：终止条件：当两个链表都为空时，表示我们对链表已合并完成。
   //         如何递归：我们判断l1和l2头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。（调用递归）
   // 时间复杂度：O(n+m)，空间复杂度：O(n+m)  其中n和m分别是两个链表的长度
   // 时间复杂度说明：因为每次调用递归都会去掉l1或者l2的头节点（直到至少有一个链表为空）函数 mergeTwoList 至多只会递归调用每个节点一次
   //             因此，时间复杂度取决于合并后的链表长度
   // 空间复杂度说明：递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。结束递归调用时 mergeTwoLists 函数
   //              最多调用n+m次，
   // 参考资料1：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/(官方解)
   // 备注1：递归法没有掌握！！！！
   class Solution {
       public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
           if (l1 == null) {
               return l2;
           } else if (l2 == null) {
               return l1;
           } else if (l1.val < l2.val) {
               l1.next = mergeTwoLists(l1.next, l2);
               return l1;
           } else {  // l1.val >= l2.val
               l2.next = mergeTwoLists(l1, l2.next);
               return l2;
           }
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}