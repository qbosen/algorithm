package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 区域和检索 - 数组可修改
// 307
/* ["NumArray","sumRange","update","sumRange"],[[[1,3,5]],[0,2],[1,2],[0,2]] */

fun main() {
    val test1 = RangeSumQueryMutable.NumArray("[1,3,5]".to1DIntArray())
    assertThat(test1.sumRange(0, 2), equalTo(9))
    test1.update(1, 2)
    assertThat(test1.sumRange(0, 2), equalTo(8))

    val test2 = RangeSumQueryMutable.NumArray("[7,2,7,2,0]".to1DIntArray())
    test2.update(4, 6)      // 7,2,7,2,6
    test2.update(0, 2)      // 2,2,7,2,6
    test2.update(0, 9)      // 9,2,7,2,6
    assertThat(test2.sumRange(4, 4), equalTo(6))
    test2.update(3, 8)      // 9,2,7,8,6
    assertThat(test2.sumRange(0, 4), equalTo(32))
    test2.update(4, 1)      // 9,2,7,8,1
    assertThat(test2.sumRange(0, 3), equalTo(26))
    assertThat(test2.sumRange(0, 4), equalTo(27))
    test2.update(0, 4)      // 4,2,7,8,1
    assertThat(test2.sumRange(0, 4), equalTo(22))

}

class RangeSumQueryMutable {
    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray(nums: IntArray) {
        val BIT = IntArray(nums.size + 1)

        init {
            nums.withIndex().forEach { BIT[it.index + 1] = it.value }
            for (i in 1..BIT.lastIndex) {
                val j = i + (i and -i)  // bit[j]管理了该层的和
                if (j < BIT.size) BIT[j] += BIT[i]
            }
        }

        fun update(i: Int, `val`: Int) {
            var idx = i + 1
            val delta = `val` - sumRange(i, i)
            while (idx < BIT.size) {
                BIT[idx] += delta
                idx += (idx and -idx)
            }
        }

        fun prefixSum(`val`: Int): Int {
            var idx = `val` + 1
            var res = 0
            while (idx > 0) {
                res += BIT[idx]
                idx -= idx and (-idx)
            }
            return res
        }

        fun sumRange(i: Int, j: Int): Int {
            return prefixSum(j) - prefixSum(i - 1)
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}