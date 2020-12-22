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
   // 法一：动态规划法
   // 算法思想：见官方解的分析
   // 时间复杂度：O(n^2)，空间复杂度：O(n)  其中n表示二叉搜索树的节点个数
   // 时间复杂度说明：G(n)函数一共有n个值需要求解，每次求解需要O(n)的时间复杂度，因此总时间复杂度为O(n^2)
   // 空间复杂度说明：需要O(n)的空间存储G数组
   // 参考资料1：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/(官方解）
   class Solution {
       public int numTrees(int n) {
           int[] G = new int [n + 1];
           G[0] = 1;
           G[1] = 1;

           for (int i = 2; i <= n; i++) {
               // i就是每个循环中当前的n
               for (int j = 1; j <= i; j++) {
                   G[i] += G[j - 1] * G[i - j];
               }
           }

           return G[n];
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}