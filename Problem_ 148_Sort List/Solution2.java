//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1015 👎 0

package com.glj.leetcode.editor.cn;

public class SortList{

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);

//        node5.next = null;
        node4.next = null;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        ListNode ans = solution.sortList(node1);
        System.out.println(ans);
//        System.out.println("排序后的结果为：");
//        System.out.println(ans.val);
//        System.out.println(ans.next.val);
//        System.out.println(ans.next.next.val);
//        System.out.println(ans.next.next.next.val);
//        ListNode mid = findMid(node1);
//        System.out.println("中点为：" + mid.val);
    }

//    public static ListNode findMid(ListNode head) {
//        int len = 0;
//        ListNode curr = head;
//        while (curr != null) {
//            len++;
//            curr = curr.next;
//        }
//        System.out.println("链表长度为：" + len);
//        curr  = head;
//        for (int i = 0; i < len / 2 - 1; i++) {  // 循环len/2次
//            curr = curr.next;
//        }
//        return curr;
//    }
//    public static ListNode findMid(ListNode head) {
//        ListNode slow = head, fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }


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
    // 法二：自底向上归并排序
    // 算法思想：首先求得链表的长度length，然后将链表拆分成子链表进行合并。具体做法如下：
    //        （1）用subLength表示每次需要排序的子链表的长度，初始时subLength=1；
    //        （2）每次将链表拆分成若干个长度为subLength的子链表（最后一个子链表的长度
    //            可以小于subLength，按照每两个子链表一组进行合并，合并后即可得到若干
    //            个长度为subLength×2的有序子链表（最后一个子链表的长度可以小于subLength×2)。
    //            合并两个子链表仍然使用「Problem21. 合并两个有序链表」的做法；
    //        （3）将subLength的值加倍，重复第（2）步，对更长的有序子链表进行合并操作，
    //            直到有序子链表的长度大于或等于length，整个链表排序完毕。
    // 时间复杂度：O(nlogn)，空间复杂度：O(1)  其中n为链表中的节点数
    // 时间复杂度说明：归并排序的时间复杂度为O(nlogn)
    // 空间复杂度说明：只用到了常数复杂度的几个指针
    // 参考资料1：https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/(官方解)
    // 参考资料2：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/(K神-评论区-大胃王的解法-很赞)
    // 备注1：法一中，官方解的代码中，有一些"错误"，我的代码将其改正了
    // 备注2：法二中，参考的是官方解的第一页的评论区的代码
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return head;
            }

            // 1. 从头向后遍历链表，统计链表的长度
            int len = 0;
            ListNode node = head;
            while (node != null) {
                len++;
                node = node.next;
            }

            // 2.初始化，引入虚拟头节点
            ListNode dummyHead = new ListNode(0, head);

            // 3.每次将链表拆分成若干个长度为subLen的子链表，并按照每两个子链表一组进行合并
            for (int subLen = 1; subLen < len; subLen <<= 1) {  // subLen每次左移一位（即sublen = sublen*2） PS:位运算对CPU来说效率更高
                ListNode prev = dummyHead;
                ListNode curr = dummyHead.next;  // curr用于记录拆分链表的位置

                while (curr != null) {  // 如果链表没有被拆完
                    // 3.1 拆分subLen长度的链表1
                    ListNode head1 = curr;  // 第一个链表的头，即curr的初始位置
                    for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {    // 拆分出长度为subLen的链表1
                        // 这里要循环subLen-1次，即curr要向前移动subLen-1次，加上curr的初始位置的节点，便得到subLen长度的一段链表了
                        // 并且curr最后停在的位置即为这一段链表的最后一个节点，所以限制条件还应该有curr.next!=null
                        curr = curr.next;
                    }

                    // 3.2 拆分出subLen长度的链表2
                    ListNode head2 = curr.next;  // 第二个链表的头  即 链表1尾部的下一个位置
                    curr.next = null;  // 断开第一个链表和第二个链表的链接
                    curr = head2;  // 第二个链表头 重新赋值给curr
                    for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {  // 拆分出长度为subLen的链表1
                        curr = curr.next;
                    }

                    // 3.3 再次断开，第二个链表最后的next连接
                    ListNode next = null;
                    if (curr != null) {  // 对于curr == null的情况，说明后面无节点了，不需要断开了
                        next = curr.next;  // next用于记录 拆分完两个链表的结束位置
                        curr.next = null;  // 断开连接
                    }

                    // 3.4 合并两个subLen长度的有序链表
                    ListNode merged = merge(head1, head2);
                    prev.next = merged;  // prev.next 指向排好序链表的头
                    while (prev.next != null) {  // while循环 将prev移动到 subLen*2 的位置后去
                        prev = prev.next;
                    }
                    curr = next;              // next用于记录 拆分完两个链表的结束位置
                }  // while (curr != null) 如果链表没有拆分完
            }

            return dummyHead.next;
        }

        /**
         * 合并两个有序链表 「Problem21. 合并两个有序链表」
         * @param head1
         * @param head2
         * @return
         */
        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(-1);

            ListNode prev = dummyHead;
            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    prev.next = head1;
                    head1 = head1.next;
                } else {
                    prev.next = head2;
                    head2 = head2.next;
                }
                prev = prev.next;
            }
            prev.next = head1 == null ? head2 : head1;
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}