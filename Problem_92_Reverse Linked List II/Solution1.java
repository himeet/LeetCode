//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 681 👎 0

package com.glj.leetcode.editor.cn;

public class ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
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
    // 法一：迭代法
    // 算法思想：（1）在对链表交换时，需要设置两个指针prev和curr，这两个指针可以完成链表中某一段的反转(同时需要一个tmp暂存curr.next）；
    //         （2）将prev初始化为null，curr初始化为链表的头节点head；
    //         （3）一步步向前推进curr指针，prev指针紧跟其后；
    //         （4）如此推进两个指针，直到curr指针到达从链表头起的m个结点，这就是我们反转链表的起始位置；
    //         （5）我们要引入两个额外指针，tail和con。tail指针指向从链表头节点起的第m个节点，此节点是链表反转后的那部分的尾部。
    //             con指向第m个节点的前一个节点，此节点是新链表那部分的头部的前一个节点。
    //             可以理解为  xx->xx->con->反转后的部分(这部分的最后一个节点为tail)->xx->xx
    // 时间复杂度：O(n)，空间复杂度：O(1)
    // 时间复杂度说明：最多遍历n个节点
    // 空间复杂度说明：只用到了几个指针的额外空间
    // 参考资料1：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode/(官方解)
    // 备注1：注意这题目的反转范围是两侧闭区间，即[left, right]
    // 备注2：代码不完全和官方解一样，根据自己的理解改编的
    // 备注3：递归的解法还没看，记得补上！！
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 移动prev和curr直到他们到达指定位置
            ListNode prev= null, curr = head;
            for (int i = 0; i < left - 1; i++) {  // 循环left - 1次curr到达第left个节点
                prev = curr;
                curr = curr.next;
            }

            // 使用tail和con指针固定位置
            ListNode tail = curr, con = prev;

            // 开始反转连链表的一部分
            // 反转结束后，prev停留在第right个节点处，curr停留在第right+1个节点处
            for (int i = left; i < right + 1; i++) {  // 循环right - left + 1次
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // 组合新的链表
            if (con != null) {
                tail.next = curr;
                con.next = prev;
            } else {  // 如果con==null，即从第一个节点开始反转
                tail.next = curr;
                head = prev;
            }

            return head;  // head一直指向链表的头
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}