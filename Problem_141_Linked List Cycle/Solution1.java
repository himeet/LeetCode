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
   // 法一：哈希表法
   // 算法思想：使用哈希表存放已经访问过的节点，每访问到一个节点，判断哈希表中是否存在；
   //         若存在，则存在环；
   //         遍历完整个链表都没返回true，说明不存在环。
   // 时间复杂度：O(n)，空间复杂度：O(n) 其中n为链表的长度
   // 时间复杂度说明：最多遍历n个节点
   // 空间复杂度说明：使用了额外的hashSet存放链表节点，最多存放n个节点
   // 参考资料1：https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/(官方解)
   public class Solution {
       public boolean hasCycle(ListNode head) {
           Set<ListNode> hashSet = new HashSet<>();
           ListNode curr = head;
           while (curr != null) {
               hashSet.add(curr);
               if (hashSet.contains(curr.next)) {
                   return true;
               }
               curr = curr.next;
           }
           return false;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}