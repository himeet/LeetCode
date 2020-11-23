//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 199 👎 0
 
package com.glj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi{
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    // 法二：动态规划法
    // 算法思想：利用杨辉三角后一行与前一行的的关系
    //          更新过程为：从倒数第二个元素开始往前更新，它等于原来这个位置的数+前一个位置的数
    //                     即行[i] = 行[i] + 行[i-1]
    //          可以理解为将二维数组拉成一维数组
    // 时间复杂度：O(k^2)，空间复杂度：O(k) 其中k为杨辉三角的行索引rowIndex
    // 时间复杂度说明：遍历0*0+1*0+2*1+3*2+...+(k+1)*k次，为k^2
    // 空间复杂度说明：使用了长度为rowIndex+1的ans List，若ans不算空间复杂度，则空间复杂度为O(1)
    // 参考资料3：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/119yang-hui-san-jiao-ii-dong-tai-gui-hua-by-ceng-j/
    // 备注：分析过程见ipad
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            // 返回的结果
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < rowIndex + 1; i++) {  // 利用前一行求后一行，第n行要循环n=rowIndex+1遍
                ans.add(1);  // 行末尾为1
                for (int j = i; j > 1; j--) {  // 每一行的更新过程
                    ans.set(j-1, ans.get(j-1) + ans.get(j-2));
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}