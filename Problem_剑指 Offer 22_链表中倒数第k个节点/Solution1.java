//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 139 👎 0

package com.glj.leetcode.editor.cn;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import java.util.LinkedList;
import java.util.List;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

   //leetcode submit region begin(Prohibit modification and deletion)
   /**
    * Definition for singly-linked list.
    * public class ListNode {
    *     int val;
    *     ListNode next;
    *     ListNode(int x) { val = x; }
    * }
    */
   // 法一：借助数组存储法
   // 算法思想：遍历整个链表一遍，同时将遍历到的节点存储到数组中，最终返回数组中倒数第k个元素即可
   // 时间复杂度：O(n)，空间复杂度：O(n) 其中n为链表的长度
   // 时间复杂度说明：需要遍历整个链表一遍
   // 空间复杂度说明：需要一个O(n)复杂度的数组的额外空间
   // 参考资料1：无
   // 备注：法一是自己想的方法
   class Solution {
       public ListNode getKthFromEnd(ListNode head, int k) {
           // 将链表中所有节点存储到数组中
           List<ListNode> visited = new LinkedList<>();
           ListNode curr = head;
           while (curr != null) {
               visited.add(curr);
               curr = curr.next;
           }
           // 返回数组中倒数第k个节点
           return visited.get(visited.size() - k);
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}