/*
 * @lc app=leetcode.cn id=1744 lang=java
 *
 * [1744] 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 */

// @lc code=start
class Solution {
    public boolean[] canEat(int[] cs, int[][] qs) {
        int n = qs.length, m = cs.length;
        boolean[] ans = new boolean[n];
        long[] sum = new long[m + 1];
        for (int i = 1; i <= m; i++)
            sum[i] = sum[i - 1] + cs[i - 1];
        for (int i = 0; i < n; i++) {
            int t = qs[i][0], d = qs[i][1] + 1, c = qs[i][2];
            long a = sum[t] / c + 1, b = sum[t + 1];
            ans[i] = a <= d && d <= b;
        }
        return ans;
    }
}

// @lc code=end