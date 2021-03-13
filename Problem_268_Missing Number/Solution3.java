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
    // 法三：数学法
    // 算法思想：使用等差数列求和公式求出[0,n]的和，再减去数组中元素的和，即为ans
    // 时间复杂度：O(n)，空间复杂度：O(1) 其中n为数组的长度
    // 时间复杂度说明：遍历了一遍数组
    // 空间复杂度说明：只用到了常数复杂度的额外空间
    // 参考资料1：https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/(官方解)
    class Solution {
        public int missingNumber(int[] nums) {
            // 使用等差数列求和公式求出[0,n]的和
            // 公式为：S = n*（a1 + an）/ 2
            int n = nums.length;
            int sum1 = (n + 1) * (0 + n) / 2;

            // 求数组的和
            int sum2 = 0;
            for (int i = 0; i < nums.length; i++) {
                sum2 += nums[i];
            }

            return sum1 - sum2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}