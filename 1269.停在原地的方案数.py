#
# @lc app=leetcode.cn id=1269 lang=python3
#
# [1269] 停在原地的方案数
#

# @lc code=start
class Solution:
    def numWays(self, steps: int, arrLen: int) -> int:
        mod = 10**9 + 7
        max_bound = min(arrLen-1, steps)

        # i步到j位置时的方案
        # dp[i][j] = d[i-1][j-1]+d[i-1][j]+d[i-1][j+1]
        dp = [0] * (max_bound+1)
        dp[0] = 1
        for i in range(1, steps+1):
            dp_next = [0] * (max_bound+1)
            for j in range(0, max_bound+1):
                dp_next[j] = dp[j]
                if j-1 >= 0:
                    dp_next[j] = (dp_next[j] + dp[j-1]) % mod
                if j+1 <= max_bound:
                    dp_next[j] = (dp_next[j] + dp[j+1]) % mod
            dp = dp_next
        return dp[0]
# @lc code=end
