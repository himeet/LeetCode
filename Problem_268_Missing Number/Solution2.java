//给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。 
//
// 
//
// 进阶： 
//
// 
// 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题? 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,0,1]
//输出：2
//解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：2
//解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 3： 
//
// 
//输入：nums = [9,6,4,2,3,5,7,0,1]
//输出：8
//解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 4： 
//
// 
//输入：nums = [0]
//输出：1
//解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// 0 <= nums[i] <= n 
// nums 中的所有数字都 独一无二 
// 
// Related Topics 位运算 数组 数学 
// 👍 375 👎 0

package com.glj.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber{
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
    }

   //leetcode submit region begin(Prohibit modification and deletion)
   // 法二：哈希表法
   // 算法思想：我们将数组中的所有数插入到一个集合中，这样每次查询操作的时间复杂度都是O(1)
   // 时间复杂度：O(n)，空间复杂度：O(n) 其中n为数组的长度
   // 时间复杂度说明：遍历了两遍数组
   // 空间复杂度说明：用到了额外的集合存储数组
   // 参考资料1：https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/(官方解)
   class Solution {
       public int missingNumber(int[] nums) {
           // 将数组存储到集合中
           Set<Integer> set = new HashSet<>();
           for (int i = 0; i < nums.length; i++) {
               set.add(nums[i]);
           }

           // 遍历[0, n]，查找缺失的元素
           int ans = 0;
           for (int i = 0; i <= nums.length; i++) {
               if (!set.contains(i)) {
                   ans = i;
                   break;
               }
           }

           return ans;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}