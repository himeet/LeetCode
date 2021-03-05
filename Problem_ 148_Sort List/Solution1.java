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
   // 法一：自顶向下归并排序
   // 算法思想：(1)找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，
   //            快指针每次移动2步，慢指针每次移动1步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点;
   //         (2)对两个子链表分别排序;
   //         (3)将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「Problem 21.合并两个有序链表」的做法，
   //            将两个有序的子链表进行合并。
   //          ps：上述过程可以通过递归实现，递归的终止条件是链表的节点个数小于或等于1，即当链表为空或者链表只包含1个
   //              节点时，不需要对链表进行拆分和排序。
   // 时间复杂度：O(nlogn)，空间复杂度：O(logn)  其中n为链表中的节点数
   // 时间复杂度说明：归并排序的时间复杂度为O（nlogn）
   // 空间复杂度说明：空间复杂度主要取决于递归调用的栈空间
   // 参考资料1：https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/(官方解)
   // 参考资料2：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/(K神-评论区-大胃王的解法-很赞)
   // 备注1：官方解的代码中，有一些"错误"，我的代码将其改正了
   class Solution {
       public ListNode sortList(ListNode head) {
           return mergeSort(head);
       }

       /**
        * 链表的归并排序 递归调用
        * @param head
        * @return
        */
       public ListNode mergeSort(ListNode head) {  // mergeSort
           // 1、递归的结束条件：当链表为空 或 链表只包含1个节点，链表不需要拆分合并了，直接返回链表
           if (head == null || head.next == null) {
               return head;
           }

           // 2、找到链表的中间节点并断开链表 & 递归下探
           // 使用快慢指针找到链表的中点mid
           ListNode mid = findMid(head);
           ListNode rightHead = mid.next;
           mid.next = null;  // 这里必须将链表断开，这样左半部分才能找到此段链表的结束
           // 归并排序左半部分链表
           ListNode left = mergeSort(head);
           // 归并排序右半部分链表 ps:官方解这里是mid（是错误的，应该是mid.next）
           ListNode right = mergeSort(rightHead);

           // 3、当前层业务操作
           ListNode sortedList = merge(left, right);

           return sortedList;
       }

       /**
        * 找到链表的中间节点（Problem876. 链表的中间结点）
        * 使用快慢指针法
        * @param head
        * @return
        */
       public ListNode findMid(ListNode head) {
           ListNode slow = head, fast = head;
           while (fast.next != null && fast.next.next != null) {
               slow = slow.next;
               fast = fast.next.next;
           }
           return slow;
       }

       /**
        * 合并两个有序链表 （Problem21. 合并两个有序链表）
        * 这里使用「迭代法」来合并两个有序链表
        * @param head1
        * @param head2
        * @return
        */
       public ListNode merge(ListNode head1, ListNode head2) {
           ListNode dummyHead = new ListNode(-1);

           ListNode prev = dummyHead;  // 需要维护一个prev节点
           // 注意：为了不改变head1和head2，这里使用额外的指针curr来遍历链表！
           ListNode curr1 = head1, curr2 = head2;
           while (curr1 != null && curr2 != null) {
               if (curr1.val < curr2.val) {
                   prev.next = curr1;
                   curr1 = curr1.next;
               } else {
                   prev.next = curr2;
                   curr2 = curr2.next;
               }
               prev = prev.next;
           }
           // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
           prev.next = curr1 == null ? curr2 : curr1;

           return dummyHead.next;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}