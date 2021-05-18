#
# @lc app=leetcode.cn id=1442 lang=python3
#
# [1442] 形成两个异或相等数组的三元组数目
#

# @lc code=start
class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        prefix = [0]
        for i in arr:
            prefix.append(prefix[-1] ^ i)
        
        n = len(arr)
        ans = 0
        for i in range(n):
            for k in range(i+1,n):
                if prefix[i] == prefix[k+1]:
                    ans +=(k -i)

        return ans
# @lc code=end

