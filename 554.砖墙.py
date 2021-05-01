import collections
#
# @lc app=leetcode.cn id=554 lang=python3
#
# [554] 砖墙
#

# @lc code=start


class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        cnt = collections.defaultdict(int)
        for row in wall:
            idx = 0
            for i in range(len(row) - 1):
                idx += row[i]
                cnt[idx] += 1

        return len(wall) - max(cnt.values(), default=0)
# @lc code=end
