//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1519 👎 0

package com.glj.leetcode.editor.cn;

public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode () {

        }
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
    // 算法思想：
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是链表的长度
    // 时间复杂度说明：需要对链表的每个节点进行反转操作。
    // 空间复杂度说明：空间复杂度主要取决于递归调用的栈空间，最多为n层
    // 参考资料1：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/(官方解)
    // 参考资料2：https://mp.weixin.qq.com/s/pnvVP-0ZM7epB8y3w_Njwg(代码随想录)
    // 备注1：对于迭代法，代码随想录中的算法思想描述和算法注释较为易懂
    // 备注2：对于递归法不理解，没掌握！！！
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}