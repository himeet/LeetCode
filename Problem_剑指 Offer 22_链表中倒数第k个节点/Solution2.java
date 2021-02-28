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
   // 法二：统计链表长度法
   // 算法思想：首先遍历整个链表，获得整个链表的长度n，然后指针向前移动n-k次，即可到达倒数第k个节点
   // 时间复杂度：O(n)，空间复杂度：O(1) 其中n为链表的长度
   // 时间复杂度说明：最多遍历整个链表2次
   // 空间复杂度说明：只需要常数个指针
   // 参考资料1：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/solution/mian-shi-ti-22-lian-biao-zhong-dao-shu-di-kge-j-11/(k神)
   // 备注2：法二中，思路借助k神，代码自己写的
   class Solution {
       public ListNode getKthFromEnd(ListNode head, int k) {
           // 获取链表长度
           int len = 0;
           ListNode curr = head;
           while (curr != null) {
               len += 1;
               curr = curr.next;
           }
           // 从头遍历链表找到倒数第k个节点
           curr = head;
           for (int i = 0; i < len - k; i++) {  // 循环len-k次
               curr = curr.next;
           }
           return curr;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}