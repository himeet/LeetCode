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
    // 法二：动态规划法-空间优化
    // 算法思想：详见参考资料1和2。
    //         相比于法一，这里做了空间的优化，因为f(x)=f(x-1)+f(x-2)，所以只需要储存f(x-1)和f(x-2)即可，不需要开辟一个dp数组了。
    //         这里使用滚动数组的思想优化空间。
    // 时间复杂度：O(n)，空间复杂度：O(1) 其中n为链表的长度
    // 时间复杂度说明：遍历一遍数组
    // 空间复杂度说明：只使用了常数复杂度的变量
    // 参考资料1：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/(官方解，带视频讲解,空间优化)
    // 参考资料2：https://leetcode-cn.com/problems/climbing-stairs/solution/wo-shi-yi-zhi-xiao-qing-wa-by-belinda/(小跳蛙视频)
    // 参考资料3：https://zhuanlan.zhihu.com/p/141534942(知乎，此解法为定义dp数组，空间未优化)
    // 备注1：参考资料2中的小跳蛙视频解释了为什么f(n)=f(n-1)+f(n-2)
    // 备注2：为了更好理解，空间优化的代码和官方题解写的有差异，p q r的初始值不一样
    class Solution {
        public int climbStairs(int n) {
            if (n == 1 || n == 2 || n == 3) {
                return n;
            }
            int p = 1, q = 2, r = 3;  // p q r分别代表此时并且始终代表f(x-2) f(x-1) f(x)
            for (int i = 4; i <= n; i++) {
                p = q;
                q = r;
                r = p + q;  // 注意这里是r等于新的q和新的q的sum，而不是旧的p和q的sum
            }
            return r;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}