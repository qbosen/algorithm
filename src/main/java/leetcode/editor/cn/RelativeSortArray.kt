package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray
import java.util.*
import kotlin.collections.HashMap

//1122 数组的相对排序
/* [2,3,1,3,2,4,6,7,9,2,19],[2,1,4,3,9,6] */

fun main() {
    val result = RelativeSortArray.Solution()::relativeSortArray
    assertThat(result("[2,3,1,3,2,4,6,7,9,2,19]".to1DIntArray(), "[2,1,4,3,9,6]".to1DIntArray()), equalTo("[2,2,2,1,4,3,3,9,6,7,19]".to1DIntArray()))
}

class RelativeSortArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
            val idxMap = HashMap<Int, Int>().apply { arr2.forEachIndexed { idx, v -> put(v, idx) } }
            val comparator = Comparator<Int> { a, b ->
                (idxMap[a] ?: (idxMap.size + a)) - (idxMap[b] ?: (idxMap.size + b))
            }
            val typed = arr1.toTypedArray()
            Arrays.sort(typed, comparator)
            return typed.toIntArray()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}