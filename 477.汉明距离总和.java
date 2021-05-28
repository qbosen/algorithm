/*
 * @lc app=leetcode.cn id=477 lang=java
 *
 * [477] 汉明距离总和
 */

// @lc code=start
class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i <= 30; i++) {
            // 第i个bit上1的数量
            int count = 0;
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            res += (count) * (nums.length - count);
        }
        return res;
    }
}
// @lc code=end
