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
   // 法二：快速排序法（手撸快排）
   // 算法思想：略
   // 时间复杂度：O(nlogn)，空间复杂度：O(n)  其中n是数组的长度
   // 时间复杂度说明：快速排序的时间复杂度为O(nlogn)
   // 空间复杂度说明：快速排序使用到了递归，递归的最大深度为n
   // 参考资料1：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
   // 参考资料2：https://github.com/himeet/SortAlgorithm(小高的手撸排序算法)
   // 备注1：本题手撸实现了快速排序和堆排序算法
   class Solution {
       public int findKthLargest(int[] nums, int k) {
           quickSort(nums, 0, nums.length - 1);
           return nums[nums.length - k];
       }

       /**
        * 快速排序  递归调用
        * @param nums
        * @param low
        * @param high
        */
       public void quickSort(int[] nums, int low, int high) {  // low和high分别为本次序列中的首、尾元素下标
           // 递归结束边界：序列中只有一个元素时，不需要排序了
           if (low >= high) {
               return;
           }
           int i = low, j = high, base = nums[low];  // 左哨兵i，右哨兵j，基准元素base
           while (i < j) {  // 当跳出while循环时，i==j
               // 右哨兵从后向前移动（左哨兵为基准时，一定要右边的哨兵先移动！！！！）
               while (nums[j] >= base && i < j) {
                   j--;
               }
               // 左哨兵从前向后移动
               while (nums[i] <= base && i < j) {
                   i++;
               }
               // 交换i和j处的元素
               swap(nums, i, j);
           }
           // 此时跳出循环，i==j，i和j相遇的位置即为base应该在的位置
           // 基准元素base归位
           swap(nums, low, j);

           // 对base左边的序列进行排序
           quickSort(nums, low, j - 1);
           // 对于base右边的序列进行排序
           quickSort(nums, j + 1, high);
       }

       /**
        * 交换nums中i和j位置的元素
        * @param nums
        * @param i
        * @param j
        */
       public void swap(int[] nums, int i, int j) {
           int tmp = nums[i];
           nums[i] = nums[j];
           nums[j] = tmp;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}