/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (39.41%)
 * Likes:    384
 * Dislikes: 0
 * Total Accepted:    59.2K
 * Total Submissions: 145.2K
 * Testcase Example:  '1'
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 
 * 例如，
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "A"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 28
 * 输出: "AB"
 * 
 * 
 * 示例 3:
 * 
 * 输入: 701
 * 输出: "ZY"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        int n = columnNumber;
        StringBuffer sb = new StringBuffer();
        do {
            int r = (n -1) % 26;
            sb.append((char) ('A' + r));
            n = (n-1) / 26;
        } while (n != 0);
        return sb.reverse().toString();
    }
}
// @lc code=end
