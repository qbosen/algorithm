/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 *
 * https://leetcode-cn.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (58.11%)
 * Likes:    164
 * Dislikes: 0
 * Total Accepted:    52.3K
 * Total Submissions: 87.6K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * 
 * 
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int bound = i + k - 1;
            bound = bound < s.length() ? bound : s.length() - 1;
            inverse(arr, i, bound);
        }
        return new String(arr);
    }

    private void inverse(char[] arr, int start, int endIncluded) {
        while (start < endIncluded) {
            char t = arr[start];
            arr[start] = arr[endIncluded];
            arr[endIncluded] = t;
            start++;
            endIncluded--;
        }
    }
}
// @lc code=end
