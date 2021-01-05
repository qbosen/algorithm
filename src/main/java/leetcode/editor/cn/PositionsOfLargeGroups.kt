package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntList

//830 较大分组的位置
/* "abbxxxxzzy" */

fun main() {
    val result = PositionsOfLargeGroups.Solution()::largeGroupPositions
    assertThat(result("abbxxxxzzy"), equalTo("[[3,6]]".to2DIntList()))
    assertThat(result("abc"), equalTo("[]".to2DIntList()))
    assertThat(result("abcdddeeeeaabbbcd"), equalTo("[[3,5],[6,9],[12,14]]".to2DIntList()))
    assertThat(result("aabbbcccc"), equalTo("[[2,4],[5,8]]".to2DIntList()))
}

class PositionsOfLargeGroups {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun largeGroupPositions(s: String): List<List<Int>> {
            var prev = ' '
            var idx = 0
            val result = ArrayList<List<Int>>()
            for (i in s.indices) {
                if (s[i] == prev) continue
                if (i - idx >= 3) {
                    result.add(listOf(idx, i - 1))
                }
                idx = i
                prev = s[i]
            }
            if (s.last() == prev && s.length - idx >= 3) {
                result.add(listOf(idx, s.lastIndex))
            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}