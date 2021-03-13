//给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。 
//
// 
//
// 进阶： 
//
// 
// 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题? 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,0,1]
//输出：2
//解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：2
//解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 3： 
//
// 
//输入：nums = [9,6,4,2,3,5,7,0,1]
//输出：8
//解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 4： 
//
// 
//输入：nums = [0]
//输出：1
//解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// 0 <= nums[i] <= n 
// nums 中的所有数字都 独一无二 
// 
// Related Topics 位运算 数组 数学 
// 👍 375 👎 0

package com.glj.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber{
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
    }
  
   //leetcode submit region begin(Prohibit modification and deletion)
   // 法一：排序法
   // 算法思想：首先我们对数组进行排序，随后我们可以在常数时间内判断两种特殊情况：
   //         0没有出现在数组的首位，以及n没有出现在数组的末位。如果这两种特殊
   //         情况都不满足，那么缺失的数字一定在0和n之间（不包括两者）。此时我们
   //         可以在线性时间内扫描这个数组，如果某一个数比它前面的那个数大了超过1，
   //         那么这两个数之间的那个数即为缺失的数字。
   // 时间复杂度：O(nlogn)，空间复杂度：O(n)或O(1) 其中n为数组的长度
   // 时间复杂度说明：排序算法用到了O(nlogn)
   // 空间复杂度说明：根据排序算法是否原地，用到了O(n)或O(1)
   // 参考资料1：https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/(官方解)
   class Solution {
       public int missingNumber(int[] nums) {
           // 数组排序
           Arrays.sort(nums);
           // 特殊情况判断
           if (nums[0] != 0) {
               return 0;
           }
           if (nums[nums.length - 1] != nums.length) {
               return nums.length;
           }

           int ans = 0;
           // 缺失数字在（0，n）之间
           for (int i = 1; i < nums.length; i++) {
               if (nums[i] - nums[i - 1] > 1) {
                   ans = nums[i] - 1;
               }
           }

           return ans;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}