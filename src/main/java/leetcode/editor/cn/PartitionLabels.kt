package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 763 划分字母区间
/* "ababcbacadefegdehijhklij" */

fun main() {
    val result = PartitionLabels.Solution()::partitionLabels
    assertThat(result("ababcbacadefegdehijhklij"), equalTo(listOf(9, 7, 8)))
}

class PartitionLabels {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun partitionLabels(S: String): List<Int> {
            val last = IntArray(26)
            for (i in S.indices) {
                last[S[i] - 'a'] = i
            }
            val result = ArrayList<Int>()
            var start = 0
            var end = 0
            for (i in S.indices) {
                end = Math.max(end, last[S[i] - 'a'])
                if (i == end) {
                    result.add(end - start + 1)
                    start = end + 1
                }
            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}