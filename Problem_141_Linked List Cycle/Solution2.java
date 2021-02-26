//给定一个链表，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 104] 
// -105 <= Node.val <= 105 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
// Related Topics 链表 双指针 
// 👍 947 👎 0

package com.glj.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle{
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
    }
    class ListNode {
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
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    // 法二：快慢指针法
    // 算法思想：（1）如何确定链表中有环？
    //         分别定义 fast 和 slow指针，从头结点出发，
    //         fast指针每次移动两个节点，slow指针每次移动一个节点，
    //         如果 fast 和 slow指针在途中相遇 ，说明这个链表有环
    //         为什么fast 走两个节点，slow走一个节点，有环的话，一定会在环内相遇呢，而不是永远的错开呢?
    //         首先第一点：「fast指针一定先进入环中，如果fast 指针和slow指针相遇的话，一定是在环中相遇，这是毋庸置疑的。」
    //         fast是走两步，slow是走一步，由于相对位移，「其实相对于slow来说，fast是一个节点一个节点的靠近slow的」，所以fast一定可以和slow重合
    // 时间复杂度：O(n)，空间复杂度：O(1) 其中n为链表的长度
    // 时间复杂度说明：当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次
    //             当链表中存在环时，每一轮移动后，快慢指针的距离将减小1。而初始距离为环的长度，因此至多移动N轮
    // 空间复杂度说明：只用到了两个指针的额外空间
    // 参考资料1：https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/(官方解)
    // 备注：法一和法二均参考了环形链表II的代码
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;  // 定义快慢指针
            while (fast != null) {
                // 因为slow和fast初始为同一个head，并且后面需要判断二者是否相等，所以应该先让二
                // 者开始前进，再判断是否相等，不然一开始就相等了（slow==fast==head）
                slow = slow.next;  // 慢指针移动
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return false;  // 如果fast.next.next==null，则不存在环了就
                }
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}