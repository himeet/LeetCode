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
    // 法三：堆排序法（手撸堆排序）
    // 算法思想：略
    // 时间复杂度：O(nlogn)，空间复杂度：O(n)  其中n是数组的长度
    // 时间复杂度说明：快速排序的时间复杂度为O(nlogn)
    // 空间复杂度说明：快速排序使用到了递归，递归的最大深度为n
    // 参考资料1：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/(官方解)
    // 参考资料2：https://github.com/himeet/SortAlgorithm(小高的手撸排序算法)
    // 备注1:本题手撸实现了快速排序和堆排序算法
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 对数组进行堆排序
            heapSort(nums, nums.length);
            // 返回倒数第k个节点
            return nums[nums.length - k];
        }

        /**
         * 堆排序
         * @param nums
         * @param heapSize
         */
        public void heapSort(int[] nums, int heapSize) {
            // 首先建一个堆
            buildHeap(nums, heapSize);
            // 从最后一个节点出发，一直到第0个节点
            for (int i = heapSize - 1; i >= 0; i--) {
                swap(nums, i, 0);  // 交换堆顶元素（nums[0]）和当前堆尾元素（nums[i]）
                heapify(nums, i, 0);
            }
        }

        /**
         * 建堆：从最后一个节点的parent开始向前建堆
         * @param nums
         * @param heapSize
         */
        public void buildHeap(int[] nums, int heapSize) {
            int lastNode = heapSize - 1;
            int parent = (lastNode - 1) / 2;
            for (int i = parent; i >= 0; i--) {
                heapify(nums, heapSize, i);
            }
        }

        /**
         * 堆化：从root开始向下堆化 建大顶堆
         * @param nums
         * @param heapSize
         * @param root
         */
        public void heapify(int[] nums, int heapSize, int root) {
            // 递归结束边界
            if (root >= heapSize) {
                return;
            }

            int leftChild = 2 * root + 1;
            int rightChild = 2 * root + 2;
            int max = root;
            if (leftChild < heapSize && nums[leftChild] > nums[max]) {
                max = leftChild;
            }
            if (rightChild < heapSize && nums[rightChild] > nums[max]) {
                max = rightChild;
            }
            if (max != root) {
                swap(nums, max, root);
                heapify(nums, heapSize, max);  // 递归调用
            }
        }

        /**
         * 交换nums中i位置和j位置的元素
         * @param nums
         * @param i
         * @param j
         */
        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}