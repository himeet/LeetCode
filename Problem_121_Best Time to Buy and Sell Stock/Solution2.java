//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1497 👎 0

package com.glj.leetcode.editor.cn;

public class BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 法二：动态规划法-空间优化
    // 算法思想：注意"现金流"这一概念
    //         「空间优化只看状态转移方程」
    //         使用滚动数组来优化空间
    // 时间复杂度：O(n)，空间复杂度：O(1) 其中n为链表的长度
    // 时间复杂度说明：遍历两次数组
    // 空间复杂度说明：常量额外空间
    // 参考资料1：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/(官方解，无用)
    // 参考资料2：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/(liweiwei大佬，股票问题整理，动态规划法)
    // 备注1：动态规划法看参考资料2
    // 备注2：此题使用了二维dp数组
    class Solution {
        public int maxProfit(int[] prices) {
            // 特殊情况判断
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            // 定义滚动数组
            int[][] dp = new int[2][2];
            // 初始化
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            // 从第2天（下标为1）开始
            for (int i = 1; i < prices.length; i++) {
                // 第i天结束时未持股：
                // 情况1：昨天未持股，今天不操作
                // 情况2：昨天持股，今天卖出
                dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);  // 卖出股票，手上的现金流增加
                // 第i天结束时持股：
                // 情况1：昨天持股，今天不操作
                // 情况2：昨天未持股，今天买入
                dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], -prices[i]);  // 买入股票，手上的现金流减少
            }

            return dp[(prices.length - 1) % 2][0];  // 返回的是最后一天结束时，不持股，手上的最大现金流
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}