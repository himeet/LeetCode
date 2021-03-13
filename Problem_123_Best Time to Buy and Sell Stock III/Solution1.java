//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics 数组 动态规划 
// 👍 698 👎 0

package com.glj.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockIii{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
    }
  
   //leetcode submit region begin(Prohibit modification and deletion)
   // 法一：动态规划法-空间未优化
   // 算法思想：注意"现金流"这一概念
   //         （1）dp[i][j][k]表示在[0,i]区间内，交易进行了j次，并且第i天结束时持股状态为k时，手上持有的现金流；
   //         （2）j=0表示没有交易发生，j=1表示此时已经发生了1次买入股票的行为，j=2表示此时已经发生了2次买入股票的行为
   //             (我们人为规定记录一次交易产生是在 买入股票 的时候)；
   //         （3）k=0表示当前不持股，k=1表示当前持股；
   //         （4）初始化部分的代码思想见下列代码部分。
   // 时间复杂度：O(n)，空间复杂度：O(n) 其中n为数组的长度
   // 时间复杂度说明：遍历数组一遍
   // 空间复杂度说明：用到了dp数组
   // 参考资料1：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/dong-tai-gui-hua-by-liweiwei1419-7/(liweiwei大佬，动态规划)
   // 备注1：此题用到了三维dp数组
   // 备注2：此题很不好理解
   class Solution {
       public int maxProfit(int[] prices) {
           // 特殊情况判断
           if (prices == null || prices.length <= 1) {
               return 0;
           }

           // 定义dp数组
           int[][][] dp = new int[prices.length][3][2];

           // 初始化dp数组
           dp[0][0][0] = 0;  // 第1天（下标为0）结束时，没有交易发生，未持股
           // dp[0][0][1]   // 第1天结束时，没有交易发生，持股。此情况不存在
           dp[0][1][0] = 0;  // 第1天结束时，已经发生了一次买入股票的行为，未持股，说明当天买当天卖掉。可以认为等同于dp[0][0][0] = 0。同时浪费了一次交易机会。
           dp[0][1][1] = -prices[0];  // 第1天结束时，已经发生了1次买入股票的行为，持股。
           dp[0][2][0] = 0;  // 第1天结束时，已经发生了2次买入股票的行为，说明当天买了又卖，然后又买又卖。可以认为等同于dp[0][0][0] = 0。同时浪费了两次交易机会。
//            dp[0][2][1] = Integer.MAX_VALUE; // 第1天结束时，已经发生了2次买入股票的行为，持股。说明当天买了然后又卖，然后又买。这里不是-prices[0]，而是Integer.MAX_VALUE。记住吧，太难理解了！
           dp[0][2][1] = -prices[0];  // 第1天结束时，已经发生了2次买入股票的行为，持股。说明当天买了然后又卖，然后又买，相当于dp[0][1][1] = -prices[0]

           // 从第2天（下标为1）开始交易
           for (int i = 1; i < prices.length; i++) {
               // 转移顺序：先持股，再卖出
               dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
               dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
               dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
               dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] -prices[i]);
           }

           return Math.max(dp[prices.length - 1][1][0], dp[prices.length - 1][2][0]);
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}