//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10458 👎 0

package com.glj.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum{
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 法二：哈希表法
    // 算法思想：我们创建一个哈希表，对于每一个x，我们首先查询哈希表中是否存在target-x，
    //         然后将x插入到哈希表中，即可保证不会让x 和自己匹配。
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是数组的长度
    // 时间复杂度说明：排序使用O(nlogn)，查找使用O(n/2)即O(n)，综合起来为O(n)
    // 空间复杂度说明：略
    // 参考资料1：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/(官方解)
    // 备注：存在重复元素，此方法也适用！
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            Map<Integer, Integer> hashTable = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashTable.containsKey(target - nums[i])) {  // 哈希表中
                    ans[0] = i;
                    ans[1] = hashTable.get(target - nums[i]);
                } else {
                    hashTable.put(nums[i], i);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}