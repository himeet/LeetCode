//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 338 👎 0

package com.glj.leetcode.editor.cn;

public class AddStrings{
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 法一：模拟法
    // 算法思想：模拟竖式加法的过程即可
    //         模拟过程中需要注意的几个点：
    //        （1）我们定义两个指针i和j，分别从num1和num2的尾部出发，而不是从头部出发
    //        （2）关于进位：设置一个变量add表示当前是否有进位
    //        （3）位数不同：num1和num2的位数不同怎么办？统一在指针当前下标处于负数的时候返回0，
    //                    等价于对位数较短的数字进行了补零操作。
    // 时间复杂度：O(max(len1,len2))，空间复杂度：O(n) 其中len1和len2分别为num1和num2字符串的长度
    // 时间复杂度说明：竖式加法的次数取决于较大数的位数
    // 空间复杂度说明：StringBuffer使用了O(n)的复杂度
    // 参考资料1：https://leetcode-cn.com/problems/add-strings/solution/zi-fu-chuan-xiang-jia-by-leetcode-solution/(官方解)
    // 备注1：需要注意，对于 char类型的s='1'，int a1 = (int) s并不等于1！！！而是他的ASCII码。应该是int a2 = s - '0'这样来算！！！
    class Solution {
        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1;  // num1的指针，从右向左移动
            int j = num2.length() - 1;  // num2的指针，从右向左移动
            int add = 0;
            StringBuffer ans = new StringBuffer();

            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                ans.append(result % 10);
                add = result / 10;
                i--;
                j--;
            }
            // 计算完毕后需要将答案翻转过来
            ans.reverse();
            return ans.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}