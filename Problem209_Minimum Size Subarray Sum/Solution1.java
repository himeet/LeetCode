//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 551 👎 0

package com.glj.leetcode.editor.cn;

public class MinimumSizeSubarraySum{
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
    }
  
//leetcode submit region begin(Prohibit modification and deletion)
// 法一：暴力法
// 算法思想：暴力破解
// 时间复杂度：O(n^2)，空间复杂度：O(1) 其中n是数组nums的长度
// 时间复杂度说明：需要遍历每个下标作为子数组的开始下标，对于每个开始下标，需要遍历其后面的下标得到长度最小的子数组
// 空间复杂度说明：只用到了常数复杂度的空间
// 参考资料1：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/（官方解）
// 参考资料2：无
class Solution {
   public int minSubArrayLen(int target, int[] nums) {
       int ans = Integer.MAX_VALUE;  // Tips: 这里初始化为无穷大，而不是初始化为0。如果初始化为0，在后续的比较谁更小中会遇到0总是最小的局面
       for (int i = 0; i < nums.length; i++) {  // 这里的i不能写成[0, nums.length - 1)，因为i可以取到数组的最后一个元素
           int sum = 0;
           for (int j = i; j < nums.length; j++) {
               sum += nums[j];
               if (sum >= target) {
                   ans = Math.min(j - i + 1, ans);
                   break;  // 提早退出循环，节省时间
               }
           }
       }
       return ans == Integer.MAX_VALUE ? 0 : ans;
   }
}
//leetcode submit region end(Prohibit modification and deletion)

}