//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 871 👎 0

package com.glj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
   // 法一：数组+双指针法
   // 算法思想：复制链表的节点或链表的节点的val到数组中(为了节省空间，可以只复制节点的val)，对数组使用双指针判断是否是回文数
   // 时间复杂度：O(n)，空间复杂度：O(n)
   // 时间复杂度说明：遍历链表并复制到数组中，使用了O(n)；双指针遍历数组，进行n/2次判断，也是O(n)的复杂度
   // 空间复杂度说明：使用了额外的一个数组存放节点或节点的值
   // 参考资料1：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/(官方解)
   class Solution {
       public boolean isPalindrome(ListNode head) {
           // 将链表节点的val复制到数组中
           List<Integer> arr = new ArrayList<>();
           ListNode curr = head;
           while (curr != null) {
               arr.add(curr.val);
               curr = curr.next;
           }

           // 在数组上使用双指针判断是否回文
           int left = 0, right = arr.size() - 1;  // 设置双指针
           while (left < right) {
//                if (arr.get(left) != arr.get(right)) {  // 这里不能用!=来判断Ingeter类型的！！
//                    return false;
//                }
               if (!arr.get(left).equals(arr.get(right))) {  // 这里不能用!=来判断Ingeter类型的！！
                   return false;
               }
               left++;
               right--;
           }

           return true;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}