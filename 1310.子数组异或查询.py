#
# @lc app=leetcode.cn id=1310 lang=python3
#
# [1310] 子数组异或查询
#

# @lc code=start
class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        prefix = [0]
        for i in arr:
            prefix.append(prefix[-1] ^ i)
        # [a,b] = prefix[b+1] ^ prefix[a]
        res = []
        for i, j in queries:
            res.append(prefix[i] ^ prefix[j + 1])
        return res
# @lc code=end
