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
   // 法一：哈希表法
   // 算法思想：一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；
   //         一旦遇到了此前遍历过的节点，就可以判定链表中存在环。借助哈希表可
   //         以很方便地实现。
   // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是链表中节点的数量
   // 时间复杂度说明：我们恰好需要访问链表中的每一个节点。
   // 空间复杂度说明：我们需要将链表中的每个节点都保存在哈希表当中
   // 参考资料1：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/(官方解)
   // 备注：代码不是官方解，是根据官方解用自己的理解写的
   public class Solution {
       public ListNode detectCycle(ListNode head) {
           ListNode curr = head;
           Set<ListNode> visited = new HashSet<>();
           while (curr != null) {
               visited.add(curr);  // 将当前访问节点存入hashSet
               if (visited.contains(curr.next)) {
                   return curr.next;
               }
               curr = curr.next;  // 指针向后移动
           }
           return null;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}