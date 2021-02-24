package leetcode.editor.cn

import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers
import org.hamcrest.Matchers.*
import util.to1DIntArray

//922 按奇偶排序数组 II
/* [4,2,5,7] */

fun main() {
    val result = SortArrayByParityIi.Solution()::sortArrayByParityII
    val matcher = object : BaseMatcher<IntArray>() {
        override fun matches(actual: Any?): Boolean {
            val arr = actual as? IntArray ?: return false
            return arr.withIndex().all { it.index % 2 == it.value % 2 }
        }

        override fun describeTo(description: Description?) {
            // nothing
        }
    }
    assertThat(result("[4,2,5,7]".to1DIntArray()), matcher)
}

class SortArrayByParityIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun sortArrayByParityII(A: IntArray): IntArray {
            var i = 0
            var j = 1
            val res = IntArray(A.size)
            A.forEach {
                if (it % 2 == 0) {
                    res[i] = it.also { i += 2 }
                } else {
                    res[j] = it.also { j += 2 }
                }
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}