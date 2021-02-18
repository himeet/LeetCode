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
// 法二：双指针法(滑动窗口法)
// 算法思想：本题中实现滑动窗口，需要确定以下三点：
//         （1）窗口内是什么？窗口内就是满足 其和>=target 的长度最小的连续子数组
//         （2）如何移动窗口的起始位置？如果当前窗口的值大于等于target了，窗口就要向前移动了（也就是应该缩小窗口了）
//         （3）如何移动窗口的结束位置？窗口的结束位置就是遍历数组的指针
// 时间复杂度：O(n)，空间复杂度：O(1) 其中n是数组nums的长度
// 时间复杂度说明：指针start和end最多各移动n次
// 空间复杂度说明：只用到了常数复杂度的空间
// 参考资料1：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/（官方解）
// 参考资料2：https://mp.weixin.qq.com/s/UrZynlqi4QpyLlLhBPglyg(代码随想录公众号)
// 备注1："涉及连续子数组的问题，我们通常有两种思路：一是滑动窗口、二是前缀和"
// 备注2：滑动窗口的思想解析见"代码随想录"公众号；指针的移动过程解析见"官方解"
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;  // 双指针默认指在数组nums的起始位置
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}