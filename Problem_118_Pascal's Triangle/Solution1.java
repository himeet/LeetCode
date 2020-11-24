//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 377 👎 0
 
package com.glj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    // 法一：动态规划法
    // 算法思想：
    // 时间复杂度：O(numRows^2)，空间复杂度：O(numRows^2) 其中k为杨辉三角的行索引rowIndex
    // 时间复杂度说明：无
    // 空间复杂度说明：无
    // 参考资料：https://leetcode-cn.com/problems/pascals-triangle/solution/yang-hui-san-jiao-by-leetcode/
    // 备注：
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            // 第一种情况，numRows==0时，返回0行
            if (numRows == 0) {
                return ans;
            }
            // 第二种情况，numRows==1时，一直为1
            ans.add(new ArrayList<>());
            ans.get(0).add(1);
            // 第三种情况，numRows > 1时，开始计算
            for (int rowN = 1; rowN < numRows; rowN++) {
                List<Integer> currentRow = new ArrayList<>();
                List<Integer> preRow = ans.get(rowN - 1);
                // 每行的第一个元素一直为1
                currentRow.add(1);
                // 填充每一行的中间元素，等于上一行的两个元素和
                for (int j = 1; j <= rowN + 1 - 2; j++) {  // rowN行有rowN+1个元素，减去首尾两个，即为 rowN + 1 - 2
                    currentRow.add(preRow.get(j-1) + preRow.get(j));
                }
                // 每行的最后一个元素一直为1
                currentRow.add(1);
                // 将当前行添加到ans中
                ans.add(currentRow);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}