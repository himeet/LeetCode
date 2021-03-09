//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 922 👎 0

package com.glj.leetcode.editor.cn;

import java.util.Arrays;

public class KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = {3,2,1,5,6,4};
        solution.heapSort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }
  
   //leetcode submit region begin(Prohibit modification and deletion)
   // 法一：快速排序法（调库）
   // 算法思想：略
   // 时间复杂度：O(nlogn)，空间复杂度：O(n)  其中n是数组的长度
   // 时间复杂度说明：快速排序的时间复杂度为O(nlogn)
   // 空间复杂度说明：快速排序使用到了递归，递归的最大深度为n
   // 参考资料1：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
   // 备注：无
   class Solution {
       public int findKthLargest(int[] nums, int k) {
           Arrays.sort(nums);
           return nums[nums.length - k];
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}