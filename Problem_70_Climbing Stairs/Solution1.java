//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1526 👎 0

package com.glj.leetcode.editor.cn;

public class ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }
  
   //leetcode submit region begin(Prohibit modification and deletion)
   // 法一：动态规划法-空间未优化
   // 算法思想：详见参考资料1和2
   // 时间复杂度：O(n)，空间复杂度：O(n) 其中n为链表的长度
   // 时间复杂度说明：遍历一遍数组
   // 空间复杂度说明：使用了一个长度为n+1的dp数组
   // 参考资料1：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/(官方解，带视频讲解，空间优化)
   // 参考资料2：https://leetcode-cn.com/problems/climbing-stairs/solution/wo-shi-yi-zhi-xiao-qing-wa-by-belinda/(小跳蛙视频)
   // 参考资料3：https://zhuanlan.zhihu.com/p/141534942(知乎，此解法为定义dp数组，空间未优化)
   // 备注1：参考资料2中的小跳蛙视频解释了为什么f(n)=f(n-1)+f(n-2)
   class Solution {
       public int climbStairs(int n) {
           if (n == 1 || n == 2) {
               return n;
           }

           // 定义dp数组，dp[i]表示爬i阶台阶的方案数。数组长度为n+1的原因是dp[0]空着不用，因为题目说n是正整数。
           int[] dp = new int[n + 1];
           dp[1] = 1;
           dp[2] = 2;

           for (int i = 3; i <= n; i++) {
               dp[i] = dp[i - 1] + dp[i - 2];
           }

           return dp[n];
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}