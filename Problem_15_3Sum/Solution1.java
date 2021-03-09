//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3059 👎 0

package com.glj.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 法一：排序+双指针法
    // 算法思想：暴力法的时间复杂度是 O(n^3)。可以先固定一个值，然后寻找后两个值时可采取双指针的方法，
    //         将总的时间复杂度优化到 O(n^2)。实现的过程中，要注意优化以及去重。
    //         首先我们先对原数组进行排序，这样可以把重复的值集中到一起，便于去重。
    //         确定第一个元素时，如果它已经比 0 大了，那么可以直接跳出循环，因为后面的数字都比它大。
    //         确定第一个元素时，如果发现它与它前面的值一样，那么跳过本轮。
    //         接下来利用双指针，left 指向 i + 1, right 指向 nums.length - 1。逐个进行判断，并注意去重。
    // 时间复杂度：O(n^2)，空间复杂度：O(logn)  其中n是数组的长度
    // 时间复杂度说明：略
    // 空间复杂度说明：额外的排序的空间复杂度为O(logN)
    // 参考资料1：https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/(官方解)
    // 参考资料2：https://blog.csdn.net/starflyyy/article/details/106955473(CSDN)
    // 备注1:CSDN的解法更加易懂
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();
            if (nums == null || nums.length <= 2) {
                return ans;
            }

            // 首先对数组排序
            Arrays.sort(nums);  // O(nlogn)
            // 寻找答案
            for (int i = 0; i < nums.length - 2; i++) {  // O(n^2)
                if (nums[i] > 0) {  // 第一个数大于0，后面的数都比它大，后面没必要循环了，肯定不成立了。直接跳出循环
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {  // 去掉重复情况，跳过本次循环
                    continue;
                }
                int target = -nums[i];
                int left = i + 1, right = nums.length - 1;  // 双指针
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        ans.add(new LinkedList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                        // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = -2,
                        // left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和3
                        left++; right--; // 首先无论如何先要进行加减操作
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {  // nums[left] + nums[right] > target
                        right--;
                    }
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}