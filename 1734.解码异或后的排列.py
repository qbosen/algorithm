#
# @lc app=leetcode.cn id=1734 lang=python3
#
# [1734] 解码异或后的排列
#

# @lc code=start
class Solution:
    def decode(self, encoded: List[int]) -> List[int]:
        n = len(encoded) + 1
        total = 0
        for i in range(0, (n + 1) % 4):
            total ^= n - i
        odd = 0
        for i in range(1, n - 1, 2):
            # encoded[i] = perm[i] ^ perm[i+1], n is odd
            # e[1] xor e[3].. xor e[n-2] = p[1] xor p[2] xor p[3] xor p[4] ... p[n-2] xor p[n-1]
            odd ^= encoded[i]
        perm = [total ^ odd]
        for i in range(n - 1):
            perm.append(perm[-1] ^ encoded[i])

        return perm

# @lc code=end
