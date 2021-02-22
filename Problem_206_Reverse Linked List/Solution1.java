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
   // 法一：迭代法
   // 算法思想：首先定义一个cur指针，指向头结点，再定义一个pre指针，初始化为null。
   //         然后就要开始反转了，首先要把 cur->next 节点用tmp指针保存一下，也就是保存一下这个节点。
   //         为什么要保存一下这个节点呢，因为接下来要改变 cur->next 的指向了，将cur->next 指向pre，
   //         此时已经反转了第一个节点了。
   //         接下来，就是循环走如下代码逻辑了，继续移动pre和cur指针。
   //         最后，cur指针已经指向了null，循环结束，链表也反转完毕了。此时我们return pre指针就可以了，
   //         pre指针就指向了新的头结点。
   // 时间复杂度：O(n)，空间复杂度：O(1)  其中n是链表的长度
   // 时间复杂度说明：需要遍历链表一次
   // 空间复杂度说明：只用到了常数复杂度的额外空间
   // 参考资料1：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/(官方解)
   // 参考资料2：https://mp.weixin.qq.com/s/pnvVP-0ZM7epB8y3w_Njwg(代码随想录)
   // 备注：对于迭代法，代码随想录中的算法思想描述和算法注释较为易懂
   class Solution {
       public ListNode reverseList(ListNode head) {
           ListNode prev = null;
           ListNode curr = head;
           while (curr != null) {
               ListNode next = curr.next;  // next起到tmp作用，不然curr.next就丢失了
               curr.next = prev;  // 翻转操作
               // 更新prev和curr指针，向前移动
               prev = curr;
               curr = next;
           }
           return prev;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}