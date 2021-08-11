import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=446 lang=java
 *
 * [446] 等差数列划分 II - 子序列
 *
 * https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/description/
 *
 * algorithms
 * Hard (37.98%)
 * Likes:    179
 * Dislikes: 0
 * Total Accepted:    12.2K
 * Total Submissions: 23.9K
 * Testcase Example:  '[2,4,6,8,10]'
 *
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * 
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * 
 * 
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 
 * 
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * 
 * 
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 
 * 
 * 题目数据保证答案是一个 32-bit 整数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [2,4,6,8,10]
 * 输出：7
 * 解释：所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [7,7,7,7,7]
 * 输出：16
 * 解释：数组中的任意子序列都是等差子序列。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1  <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // 定义等差对
        // dp[i][d] i: 以nums[i]结尾的等差对个数 d: 公差
        // 公差范围可能很大 且可能重复 做hash去重
        // dp[i][d] += dp[j][d]+1; nums[i]-nums[j]=d

        int ans = 0;
        int n = nums.length;
 
        Map<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = 1L * nums[i] - nums[j];
                int cnt = dp[j].getOrDefault(d, 0);
                ans += cnt;
                dp[i].put(d, dp[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}
// @lc code=end
