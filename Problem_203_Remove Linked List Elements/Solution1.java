//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 535 👎 0

package com.glj.leetcode.editor.cn;

public class RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

//leetcode submit region begin(Prohibit modification and deletion)
// 法一：虚拟头节点法
// 算法思想：如果要删除的节点为中间节点或者尾节点，操作是一致的；如果删除的是头节点，则操作并不一致
//         此时就需要单独写一段逻辑来处理头节点。为了保证处理逻辑的一致性，在头节点前添加一个虚拟头节点
// 时间复杂度：O(n)，空间复杂度：O(1)
// 时间复杂度说明：只遍历了一次
// 空间复杂度说明：只用到了常数的额外空间
// 参考资料1：https://mp.weixin.qq.com/s/slM1CH5Ew9XzK93YOQYSjA(代码随想录)
// 参考资料2：https://leetcode-cn.com/problems/remove-linked-list-elements/solution/yi-chu-lian-biao-yuan-su-by-leetcode/(官方解)
// 备注：算法思想见代码随想录，代码部分见官方解和代码随想录
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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {  // 删除节点
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}