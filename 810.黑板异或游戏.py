#
# @lc app=leetcode.cn id=810 lang=python3
#
# [810] 黑板异或游戏
#

# @lc code=start
class Solution:
    def xorGame(self, nums: List[int]) -> bool:
        if len(nums) % 2 == 0:
            return True
        
        xorsum = reduce(xor, nums)
        return xorsum == 0

# @lc code=end

