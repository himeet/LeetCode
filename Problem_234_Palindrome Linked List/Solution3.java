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
    // 法三：快慢指针法
    // 算法思想：将链表的后半部分反转（修改链表结构），将前半部分和后半部分进行比较，看是否为回文数。最后记得恢复链表
    //        （1）找到前半部分链表的尾节点
    //            方法1：可以计算链表节点的数量，然后遍历链表找到前半部分的尾节点
    //            方法2：使用快慢指针一次遍历得到：慢指针走一步，快指针走2步，快指针移动到链表尾部时，慢指针恰好到链表中间
    //        （2）反转后半部分链表
    //        （3）判断是否回文
    //        （4）恢复链表
    // 时间复杂度：O(n)，空间复杂度：O(1)  其中n为链表中的节点数
    // 时间复杂度说明：全部操作都是O(n)的累加
    // 空间复杂度说明：只用到了常数复杂度的几个额外指针
    // 参考资料1：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/(官方解)
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head==null) {  // 这个需要加，不然会出现空指针异常
                return true;
            }
            // 找到前半部分链表的尾节点
            ListNode firstHalfTail = findTailofFirstHalf(head);
            // 反转后半部分的链表
            ListNode secondHalfHead = reverseList(firstHalfTail.next);  // 反转的是第一部分的尾节点的后一个节点
            // 判断是否回文
            boolean ans = true;  // 使用ans的目的是最后能够还原链表
            ListNode p1 = head, p2 = secondHalfHead;
            while (p2 != null) {  // 第一段的长度等于第二段的长度，或者第一段的长度=第二段的长度+1，所以这里用p2(短的那一段)作为中止条件
                if (p1.val != p2.val) {
                    ans = false;
                    break;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            // 恢复链表
            firstHalfTail.next = reverseList(secondHalfHead);
            // 返回结果
            return ans;
        }

        /**
         * 找到前半部分链表的尾节点
         * @param head
         * @return
         */
        public ListNode findTailofFirstHalf(ListNode head) {
            ListNode slow = head, fast = head;
            // 判断条件为什么是fast.next和fast.next.next均要!=null 画一个5个节点的链表和6个节点的链表就懂了
            // 对于奇数节点是fast.next!=null；对于偶数节点是fast.next.next!=null
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        /**
         * 反转以head开头的链表
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            return prev;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}