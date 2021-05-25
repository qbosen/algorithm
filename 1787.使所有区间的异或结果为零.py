#
# @lc app=leetcode.cn id=1787 lang=python3
#
# [1787] 使所有区间的异或结果为零
#

# @lc code=start
class Solution:
    def minChanges(self, nums: List[int], k: int) -> int:
        n = len(nums)
        counters = defaultdict(Counter)
        for i in range(k):
            for j in range(i, n, k):
                counters[i][nums[j]] += 1

        # 每组数的众数
        msv = [counters[i].most_common(1)[0][1] for i in range(k)]
        # 每组全部变为同样的数的最小代价
        ans = n - sum(msv)

        # 每组数都是众数，要满足异或为0，需要统计每组数选哪个数达到最优解，或者牺牲哪组数
        @lru_cache(None)
        def dfs(idx, curr):
            if idx == k and curr == 0:
                return 0
            elif idx == k:
                return float("inf")
            # 牺牲这组数的额外代价,所有数都换为某个数，使得异或为0
            res = msv[idx]
            # 变为这组数中的某个数
            for key in counters[idx].keys():
                res = min(res, dfs(idx+1, curr ^ key) -
                          counters[idx][key] + msv[idx])
            return res
        return ans + dfs(0, 0)
# @lc code=end
