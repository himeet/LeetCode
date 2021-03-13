//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2986 👎 0

package com.glj.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = solution.maxSubArray(nums);
        System.out.println(ans);
    }

   //leetcode submit region begin(Prohibit modification and deletion)
   // 法一：动态规划-空间未优化
   // 算法思想：dp[i] = max(dp[i], dp[i-1] + dp[i])
   // 时间复杂度：O(n)，空间复杂度：O(n) 其中n为数组的长度
   // 时间复杂度说明：遍历一遍数组
   // 空间复杂度说明：用到了额外的dp数组
   // 参考资料1：https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/(官方解)
   // 参考资料2：https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/(画解算法)
   // 备注1：使用到了一维dp
   // 备注2：未看答案，自己写出来的代码是错误的，应该返回dp数组的最大值！
   // 备注3：注意返回的不是dp[n - 1]，而是max(dp[0]...dp[n-1])
   class Solution {
       public int maxSubArray(int[] nums) {
           // 1.特殊情况判断
           if (nums == null || nums.length == 0) {
               return 0;
           }

           // 2.定义dp数组
           // dp[i]表示[0, i]之间的最大子序和
           // dp[i] = max(dp[i], dp[i-1] + dp[i])
           int[] dp = new int[nums.length];

           // 3.底层边界处理
           dp[0] = nums[0];
           int ans = dp[0];

           // 4.开始遍历
           for (int i = 1; i < nums.length; i++) {
               // 注意这里要求的是连续的！！所以不是求max(dp[i-1], dp[i], dp[i-1]+dp[i])
               // 而是求max(dp[i-1]+dp[i], dp[i])
               // 不能单独的dp[i-1]而不加dp[i]，这样就断开了
//                int temp = Math.max(dp[i - 1], dp[i]); // 错误
//                dp[i] = Math.max(temp, dp[i - 1] + dp[i]);  // 错误

               dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
               ans = Math.max(dp[i], ans);
           }

           // 5.返回dp[n-1]的结果，表示找完了整个数组所得到的最大子序和
           return ans;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}
