#
# @lc app=leetcode.cn id=664 lang=python3
#
# [664] 奇怪的打印机
#

# @lc code=start
class Solution:
    def strangePrinter(self, s: str) -> int:
        n = len(s)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1
        for L in range(n-1, -1, -1):      #L依赖于右侧
            for R in range(L + 1, n):   #R依赖于左侧
                if s[L] == s[R]:
                    dp[L][R] = dp[L][R-1]
                else:
                    tmp = 1000
                    for mid in range(L, R, 1):
                        tmp = min(tmp, dp[L][mid] + dp[mid+1][R])
                    dp[L][R] = tmp
        return dp[0][n-1]
# @lc code=end

