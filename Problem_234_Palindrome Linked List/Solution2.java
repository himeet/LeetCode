//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 871 👎 0

package com.glj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
   // 法二：递归法
   // 算法思想：见官方解的说明
   // 时间复杂度：O(n)，空间复杂度：O(n)  其中n为链表中的节点数
   // 时间复杂度说明：
   // 空间复杂度说明：
   // 参考资料1：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/(官方解)
   // 备注1：递归法没掌握！！！
   class Solution {
       private ListNode frontPointer;

       public boolean isPalindrome(ListNode head) {
           frontPointer = head;  // frontPointer指针负责从head开始向前遍历链表
           return check(head);
       }

       /**
        * 检查是否是回文数，递归调用
        * @param currNode
        * @return
        */
       private boolean check(ListNode currNode) {
           if (currNode != null) {
               if (!check(currNode.next)) {
                   return false;
               }
               if (currNode.val != frontPointer.val) {
                   return false;
               }
               frontPointer = frontPointer.next;
           }
           return true;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}