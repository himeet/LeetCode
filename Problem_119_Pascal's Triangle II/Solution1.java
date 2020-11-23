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
   // 法一：数学规律法(组合数法)
   // 算法思想：通过对杨辉三角的分析（分析过程见ipad）可得出如下的规律：
   //          对于输入的索引k，则共有n=k+1行，且索引为k的行即为第n行（从第1行开始算起），且该行共有n个值，
   //          可以得出第n行中的每个值为：后一个值 = 前一个值*(n-i)/i，即 numV=res[i-1] * (n-i)/i
   // 时间复杂度：O(k)，空间复杂度：O(k) 其中k为杨辉三角的行索引rowIndex
   // 时间复杂度说明：遍历k-1次
   // 空间复杂度说明：使用了长度为rowIndex+1的ans List，若ans不算空间复杂度，则空间复杂度为O(1)
   // 参考资料1：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/zhao-gui-lu-qiu-jie-yang-hui-san-jiao-mei-yi-xing-/
   // 参考资料2：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--28/
   // 备注1：分析过程见ipad
   // 备注2：这里如果使用int，会出现int溢出的情况，应该使用long来优化代码
   class Solution {
       public List<Integer> getRow(int rowIndex) {
           // 返回的结果
           List<Integer> ans = new ArrayList<>();
           // 每行的第一个值为1
           ans.add(1);
           // 索引为rowIndex的行为第n行
           int n = rowIndex + 1;
           for (int i = 1; i < n; i++) {  // 这里是n=rowIndex+1，不是rowIndex
               long eachValOfrow = (long) ans.get(i - 1) * (long) (n - i) / i;
               ans.add((int) (eachValOfrow));
           }
           return ans;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)
}