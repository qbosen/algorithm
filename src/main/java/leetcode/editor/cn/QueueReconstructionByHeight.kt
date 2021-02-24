package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DIntArray
import java.util.*
import kotlin.collections.ArrayList

//406 根据身高重建队列
/* [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]] */

fun main() {
    val result = QueueReconstructionByHeight.Solution()::reconstructQueue
    assertThat(result("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]".to2DIntArray()), equalTo("[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]".to2DIntArray()))
}

class QueueReconstructionByHeight {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
            // 身高降序 人数升序
//            val comparator: Comparator<IntArray> = Comparator.comparing<IntArray, Int> { it[0] }.reversed().thenComparing(Comparator.comparing { it[1] })
            val comparator: Comparator<IntArray> = Comparator { a, b ->
                val i = b[0] - a[0]
                if (i == 0) a[1] - b[1] else i
            }
            Arrays.sort(people, comparator)
            val result = ArrayList<IntArray>(people.size)
            people.forEach { result.add(it[1], it) }
            return result.toArray(Array(people.size) { IntArray(2) })
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}