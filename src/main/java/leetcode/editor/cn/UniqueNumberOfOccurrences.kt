package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 1207 独一无二的出现次数
/* [1,2,2,1,1,3] */

fun main() {
    val result = UniqueNumberOfOccurrences.Solution()::uniqueOccurrences
    assertThat(result("[1,2,2,1,1,3]".to1DIntArray()), equalTo(true))
    assertThat(result("[1,2]".to1DIntArray()), equalTo(false))
    assertThat(result("[-3,0,1,-3,1,1,1,-3,10,0]".to1DIntArray()), equalTo(true))
}

class UniqueNumberOfOccurrences {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun uniqueOccurrences(arr: IntArray): Boolean {
            val map = HashMap<Int, Int>()
            arr.forEach { map.compute(it) { _, v -> if (v == null) 1 else v + 1 } }
            val distinct = HashSet<Int>()
            for (value in map.values) {
                if (distinct.contains(value)) return false
                distinct.add(value)
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}