//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5169 👎 0

package com.glj.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 法一：滑动窗口（双指针）
    // 算法思想：其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当
    //         再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
    //         如何移动？
    //         我们只要把队列的左边的元素移出就行了，直到满足题目要求！
    //         一直维持这样的队列，找出队列出现最长的长度时候，求出解！
    // 时间复杂度：O(n)，空间复杂度：O(n) 其中n为s的长度
    // 时间复杂度说明：遍历一遍s的每个字符
    // 空间复杂度说明：滑动窗口的长度最大为n
    // 参考资料1：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/(官方解)
    // 参考资料2：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/(pow神)
    // 备注1：算法思想见参考资料2的pow神的，很容易理解，代码也是。不要看官方解的代码，不好理解
    // 备注2：参考资料2中总结了「滑动窗口」类型的题目有哪些
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }

            Map<Character, Integer> map = new HashMap<>();  // 存储当前窗口内的子串 字符->索引
            int ans = 0;  // 最长字串长度
            int left = 0;  // left为滑动窗口的左下标，i相当于滑动窗口的右下标
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    left = Math.max(left, map.get(s.charAt(i)) + 1);  // 当发现窗口内存在重复元素时，窗口左指针右移
                }
                map.put(s.charAt(i), i);  // 将当前访问到的字符添加到map中
                ans = Math.max(ans, i - left + 1);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}