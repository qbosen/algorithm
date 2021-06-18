/*
 * @lc app=leetcode.cn id=483 lang=java
 *
 * [483] 最小好进制
 *
 * https://leetcode-cn.com/problems/smallest-good-base/description/
 *
 * algorithms
 * Hard (43.57%)
 * Likes:    126
 * Dislikes: 0
 * Total Accepted:    14.2K
 * Total Submissions: 24.2K
 * Testcase Example:  '"13"'
 */

// @lc code=start
class Solution {
    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }
}
// @lc code=end

