//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 867 👎 0

package com.glj.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
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
    //         (2)如果有环，如何找到环的入口？
    //         "先找到fast与slow的相遇点，再设置两个指针index1和index2分别从相遇点和head点出发，直至相遇，即为环的入口"详见参考资料2的分析
    // 时间复杂度：O(n)，空间复杂度：O(1)  其中n是链表中节点的数量
    // 时间复杂度说明：在最初判断快慢指针是否相遇时，slow指针走过的距离不会超过链表的总长度；
    //             随后寻找入环点时，走过的距离也不会超过链表的总长度。因此，总的执行时间为O(n)+O(n) = O(n)
    // 空间复杂度说明：只用到了fast slow index1 index2四个指针的额外空间
    // 参考资料1：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/(官方解)
    // 参考资料2：https://mp.weixin.qq.com/s/_QVP3IkRZWx9zIpQRgajzA(代码随想录)
    // 备注1：代码不是官方解，是根据官方解和代码随想录用自己的理解写的
    // 备注2：快慢指针法的分析见代码随想录，分析的很详细
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;  // 定义快慢指针
            while (fast != null) {
                slow = slow.next;  // 慢指针移动
                if (fast.next != null) {  // 因为快指针一次性要移动2步，所以要校验fast.next是否为空
                    fast = fast.next.next;  // 快指针移动
                } else {
                    return null;  // fast.next若为空，则不存在环
                }
                // 快慢指针相遇，此时从head点和相遇点，同时查找直至相遇
                if (slow == fast) {
                    ListNode index1 = fast;
                    ListNode index2 = head;
                    while (index1 != index2) {
                        index1 = index1.next;
                        index2 = index2.next;
                    }
                    return index1;  // 此时index1==index2，二者相遇，返回的即为环的入口点
                }
            }
            return null;  // 如果链表中无环，便会出现fast==null的情况，会跳出上述while循环
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}