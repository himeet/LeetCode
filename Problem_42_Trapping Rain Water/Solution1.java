//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2131 👎 0

package com.glj.leetcode.editor.cn;

public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = solution.trap(height);
        System.out.println(ans);
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 法一：动态规划
    // 算法思想：（1）在动态规划过程中，要求当前列的水，我们只需要关注当前列，以及左边最高的墙，右边最高的墙就够了。对于
    //             装水的多少，根据木桶效应，我们只需要看左边最高的墙和右边最高的墙中较矮的一个就够了。
    //         （2）根据较矮的那个墙和当前列的墙的高度可以分为三种情况：
    //             第一种：较矮的墙的高度大于当前列的墙的高度：当前列的水 = 较矮的一边的墙高度 - 当前列的高度
    //             第二种：较矮的墙的高度小于当前列的墙的高度：当前列的水=0
    //             第三种：较矮的墙的高度等于于当前列的墙的高度：当前列的水=0
    //         （3）使用两个数组，一个max_left[i]表示第i列左边最高墙的高度（不包含第i列），
    //             max_right[i]表示第i列右边最高墙的高度（不包含第i列）
    //             对于求max_left：max_left[i] = max(max_left[i-1], height[i-1])  // 画个图就明白了
    //             对于求max_right: max_right[i] = max(max_right[i+1], height[i+1])  // 画个图就明白了
    // 时间复杂度：O(n)，空间复杂度：O(n) 其中n为数组的长度
    // 时间复杂度说明：遍历了三次数组
    // 空间复杂度说明：用到了两个额外的dp数组
    // 参考资料1：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/(动态规划方法讲的很好，通俗易懂！)
    // 备注1：这里用到了两个一维dp数组
    // 备注2：参考资料的解题思路非常清晰，比官方解好太多了！！！
    class Solution {
        public int trap(int[] height) {
            int len = height.length;
            // 特殊情况判断
            if (height == null || len <= 2) {
                return 0;
            }

            // 定义dp数组
            int[] max_left = new int[len];  // 记录第i列左边的最高墙的高度（不包含i），其实是个dp数组
            int[] max_right = new int[len];  // 记录第i列右边的最高墙的高度（不包含i），其实是个dp数组

            // dp数组初始化
            max_left[0] = 0;
            max_left[1] = height[0];
            max_right[len - 1] = 0;
            max_right[len - 2] = height[len - 1];

            // 动态规划求max_left和max_right
            for (int i = 2; i < len; i++) {
                max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
            }
            for (int i = len - 3; i >= 0; i--) {
                max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
            }

            int sum = 0;
            // 求接到的雨水总和
            for (int i = 0; i < len; i++) {
                int minH = Math.min(max_left[i], max_right[i]);
                if (minH > height[i]) {
                    sum += (minH - height[i]);
                }
            }

            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}