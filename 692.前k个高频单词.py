#
# @lc app=leetcode.cn id=692 lang=python3
#
# [692] 前K个高频单词
#

# @lc code=start
class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        m = {}
        for w in words:
            if w not in m:
                m[w] = 1
            else:
                m[w] += 1
        sl = sorted(m.items(), key=lambda w: (-w[1], w[0]))
        return [w[0] for w in sl][:k]

# @lc code=end
