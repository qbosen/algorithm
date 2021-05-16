#
# @lc app=leetcode.cn id=421 lang=python3
#
# [421] 数组中两个数的最大异或值
#

# @lc code=start
class Tire:
    def __init__(self, val) -> None:
        self.val = val
        self.child = {}


class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:

        L = len(format(max(nums), 'b'))
        root = Tire(-1)

        for n in nums:
            cur = root
            for i in range(L -1, -1, -1):
                v = (n>>i) & 1
                if v not in cur.child:
                    cur.child[v] = Tire(v)
                cur = cur.child[v]

        res = 0
        for n in nums:
            cur = root
            total = 0
            for i in range(L-1,-1,-1):
                v = (n>>i) & 1
                if 1-v in cur.child:
                    total = total * 2 + 1
                    cur = cur.child[1-v]
                else:
                    total = total *2
                    cur = cur.child[v]
            res = max(res, total)
        return res
                
# @lc code=end
