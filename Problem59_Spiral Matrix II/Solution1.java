//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 299 👎 0

package com.glj.leetcode.editor.cn;

public class SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }
  
//leetcode submit region begin(Prohibit modification and deletion)
// 法一：直接模拟法
// 算法思想：不断填充数字+边界填充思想，具体见参考资料1
// 时间复杂度：O()，空间复杂度：O()
// 时间复杂度说明：
// 空间复杂度说明：
// 参考资料1：https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/(Leetcode非官方解)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;  // 初始化左右上下边界
        int num = 1, target = n * n;
        while (num <= target) {  // 当时，始终按照从左到右，从上到下，从右到左，从下到上的填入顺序
            for (int i = left; i <= right; i++) {  // 从左到右
                ans[top][i] = num++;
            }
            top++;  // 上边界收缩

            for (int i = top; i <= bottom; i++) {  // 从上到下
                ans[i][right] = num++;
            }
            right--;  // 右边界收缩

            for (int i = right; i >= left; i--) {  // 从右到左
                ans[bottom][i] = num++;
            }
            bottom--;  // 下边界收缩

            for (int i = bottom; i >= top; i--) {  // 从下到上
                ans[i][left] = num++;
            }
            left++;  // 左边界收缩
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}