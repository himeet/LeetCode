//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 923 👎 0

package com.glj.leetcode.editor.cn;

public class UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 法二：数学法(卡塔兰数)
    // 算法思想：见官方解的分析
    // 时间复杂度：O(n)，空间复杂度：O(1)  其中n表示二叉搜索树的节点个数
    // 时间复杂度说明：只需要循环遍历一次即可
    // 空间复杂度说明：只需要常数空间存放若干变量
    // 参考资料1：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/(官方解）
    class Solution {
        public int numTrees(int n) {
            // 在这里需要用long类型防止计算过程中的溢出
            long ans = 1;

            for (int i = 0; i < n; i++) {  // 注意这里不是 i=1 i<=n
                ans = 2 * (2 * i + 1) * ans / (i + 2);
            }

            return (int) ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}