/*
 * @lc app=leetcode.cn id=1449 lang=java
 *
 * [1449] 数位成本和为目标值的最大数字
 *
 * https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target/description/
 *
 * algorithms
 * Hard (42.78%)
 * Likes:    106
 * Dislikes: 0
 * Total Accepted:    12.7K
 * Total Submissions: 20.6K
 * Testcase Example:  '[4,3,2,5,6,7,2,5,5]\n9'
 *
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 * 
 * 
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 
 * 
 * 由于答案可能会很大，请你以字符串形式返回。
 * 
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
 * 输出："7772"
 * 解释：添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "977"
 * 也是满足要求的数字，但 "7772" 是较大的数字。
 * ⁠数字     成本
 * ⁠ 1  ->   4
 * ⁠ 2  ->   3
 * ⁠ 3  ->   2
 * ⁠ 4  ->   5
 * ⁠ 5  ->   6
 * ⁠ 6  ->   7
 * ⁠ 7  ->   2
 * ⁠ 8  ->   5
 * ⁠ 9  ->   5
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：cost = [7,6,5,5,5,6,8,7,8], target = 12
 * 输出："85"
 * 解释：添加数位 '8' 的成本是 7 ，添加数位 '5' 的成本是 5 。"85" 的成本为 7 + 5 = 12 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：cost = [2,4,6,2,4,6,4,4,4], target = 5
 * 输出："0"
 * 解释：总成本是 target 的条件下，无法生成任何整数。
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：cost = [6,10,15,40,40,40,40,40,40], target = 47
 * 输出："32211"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * cost.length == 9
 * 1 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] cost, int target) {
        // dp[i][j]:前i个数字自由选择，（成本）恰好凑成j的最大张数（价值）
        int[][] dp = new int[10][target + 1];
        for (int i = 0; i < 10; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[0][0] = 0; // dp[0][1...target] = MIN
        for (int i = 1; i <= 9; i++)
            dp[i][0] = 0;

        // 【完全背包】零钱兑换：前i种面值自由选择，（成本）恰好凑成j的最大张数（价值）
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // 1）不要当前数字
                int c = cost[i - 1]; // 2）要当前数字
                if (j - c >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - c] + 1);
                }
            }
        }

        if (dp[9][target] <= 0)
            return "0"; // 无效，凑不出target

        // DP路径回溯：最长的数字个数已经确定，总共需要dp[9][target]个数字，具体哪些数字组成才能最大？
        int i = 9, j = target;
        StringBuilder sb = new StringBuilder();
        while (i >= 1) {
            int c = cost[i - 1];
            // 【贪心】总是优先选择较大的数字：如果当前位置可以通过增加数字i（从本行的[j-c]位置转移而来），则优先选择该路径
            if (j - c >= 0 && dp[i][j] == dp[i][j - c] + 1) {
                sb.append(i);
                j = j - c;
            } else { // 否则，退而求其次，不能增加i数字，选择从dp[i-1][j]转移而来
                i--;
            }
        }

        return sb.toString();
    }
}
// @lc code=end
