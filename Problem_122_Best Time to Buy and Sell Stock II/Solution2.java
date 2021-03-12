//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组 
// 👍 1129 👎 0

package com.glj.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockIi{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 法二：动态规划法-空间优化
    // 算法思想：注意"现金流"这一概念
    // 时间复杂度：O(n)，空间复杂度：O(1) 其中n为链表的长度
    // 时间复杂度说明：遍历一次数组
    // 空间复杂度说明：额外的常数变量
    // 参考资料1：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/(liweiwei大佬，动态规划法)
    class Solution {
        public int maxProfit(int[] prices) {
            // 特殊情况判断
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            // 定义dp数组 滚动数组
            // dp[i][j]表示第i天结束并且持股状态为j时，我们手上最大的现金流
            int[][] dp = new int[2][2];

            // 初始化，底层边界处理
            // dp[i][0]表示第i天结束时，未持有股票
            // dp[i][1]表示第i天结束时，持有股票
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            // 从第2天（下标为0）开始
            for (int i = 1; i < prices.length; i++) {
                dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
                dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] - prices[i]);
            }

            return dp[(prices.length - 1) % 2][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}