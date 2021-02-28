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
    // 法三：快慢指针法
    // 算法思想：（1）构建一个快指针fast和一个慢指针slow，同时指向head；
    //         （2）快指针先向前走k步，此时快指针和慢指针相距k步；
    //         （3）然后，快指针和慢指针同时向前移动，移动步数均为1，直到快指针走到链表尽头并跳出，此时fast=链表尾节点.next
    //             此时，慢指针和链表尾节点相距k-1个节点；（a和b相距x的意思是，a走x步正好到达b的位置，而不是二者中间相隔的节点数，其实中间相隔x-1个节点数）
    //         （4）此时慢指针指的位置正好是倒数第k个节点，返回慢指针所在位置的节点即可
    // 时间复杂度：O(n)，空间复杂度：O(1)
    // 时间复杂度说明：快指针走了n步，慢指针走了n-k步
    // 空间复杂度说明：只用到了2个指针fast和slow的额外空间
    // 参考资料1：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/solution/mian-shi-ti-22-lian-biao-zhong-dao-shu-di-kge-j-11/(k神)
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast = head, slow = head;
            // fast指针先走k步
            for (int i = 0; i < k; i++) {  // 循环k次，让fast先走k步
                fast = fast.next;
            }
            // fast和slow同时向前移动，直到fast跳出链表(fast == 尾节点.next == null)
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}