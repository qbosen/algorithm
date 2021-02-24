package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import java.util.*


// 24 点游戏
// 679
/* [4,1,8,7] */

fun main() {
    val result = Two4Game.Solution()::judgePoint24
    assertThat(result("[4,1,8,7]".to1DIntArray()), equalTo(true))
    assertThat(result("[1,2,1,2]".to1DIntArray()), equalTo(false))
}

class Two4Game {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        enum class OP {
            ADD, MULTIPLY, SUBTRACT, DIVIDE
        }

        companion object {
            const val TARGET = 24
            const val EPSILON = 1E-6
        }

        fun judgePoint24(nums: IntArray): Boolean {
            val list = ArrayList<Double>()
            nums.forEach { list.add(it.toDouble()) }
            return solve(list)
        }

        fun solve(list: List<Double>): Boolean {
            if (list.isEmpty()) return false
            if (list.size == 1) return Math.abs(list[0] - TARGET) < EPSILON
            for (i in list.indices) {
                for (j in list.indices) {
                    if (i == j) continue    // i,j 有序
                    val list2 = ArrayList<Double>()
                    for (k in list.indices) {
                        if (k != i && k != j) {
                            list2.add(list[k])  // 剩下的数字 下一层
                        }
                    }
                    for (k in OP.values()) {
                        if ((k == OP.ADD || k == OP.MULTIPLY) && i > j) {   // 可逆运算
                            continue
                        }
                        val value: Any = when (k) {
                            OP.ADD -> list[i] + list[j]
                            OP.MULTIPLY -> list[i] * list[j]
                            OP.SUBTRACT -> list[i] - list[j]
                            OP.DIVIDE -> if (Math.abs(list[j]) < EPSILON) Unit else list[i] / list[j]
                        }
                        if (value is Double) list2.add(value) else continue
                        if (solve(list2)) {
                            return true
                        }
                        list2.removeAt(list2.lastIndex)
                    }
                }
            }
            return false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}