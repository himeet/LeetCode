//编写一个程序，找到两个单链表相交的起始节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表 
// 👍 994 👎 0

package com.glj.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    // 法三：双指针法
    // 算法思想：「A和B两个链表长度可能不同，但是A+B和B+A的长度是相同的，所以遍历A+B和遍历B+A一定是同时结束
    //          如果A,B相交的话A和B剩余的一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点 如果A,B不相交的
    //          话两个指针就会同时到达A+B（B+A）的尾节点」
    //          A走过的长度为a+b+c  B走过的长度为b+a+c
    //          （1）创建两个指针pA和pB，分别初始化为A的头节点和B的头节点，然后让他们向后逐节点遍历；
    //          （2）当pA到达链表的尾部时，将它重定位到链表B的头节点；同理，当pB到达链表的尾部时，将它重定位到A的头节点
    //          （3）当 pApA/pBpB 到达链表结尾时，记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交
    // 时间复杂度：O(m+n)，空间复杂度：O(1)
    // 时间复杂度说明：需要遍历A和B链表一次 其中n和m分别为链表的长度
    // 空间复杂度说明：只用到了常数复杂度的额外空间
    // 参考资料1：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode/(官方解)
    // 参考资料2：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/(图解相交链表)
    // 参考资料3：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/jiao-ni-yong-lang-man-de-fang-shi-zhao-dao-liang-2/(浪漫の视频)
    // 备注1：官方解无代码
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            ListNode a = headA;
            ListNode b = headB;
            while (a != b) {
//                if (a == null) {  // 注意这里的判断条件是 a == null 而不是 a.next ==null
//                    a = headB;
//                }
//                a = a.next;
//                if (b == null) {
//                    b = headA;
//                }
//                b = b.next;
                // 上述代码优化后的代码
                a = a == null ? headB : a.next;  // 注意这里的判断条件是 a == null 而不是 a.next ==null
                b = b == null ? headA : b.next;
            }
            return a;  // a==b时，若相交，则返回的是相交点；若没有相交点，返回的是节点的尾部的next即为null
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}