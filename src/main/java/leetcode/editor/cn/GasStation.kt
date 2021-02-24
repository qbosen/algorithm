package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//134 加油站
/* [1,2,3,4,5],[3,4,5,1,2] */

fun main() {
    val result = GasStation.Solution()::canCompleteCircuit
    assertThat(result("[1,2,3,4,5]".to1DIntArray(), "[3,4,5,1,2]".to1DIntArray()), equalTo(3))
    assertThat(result("[2,3,4]".to1DIntArray(), "[3,4,3]".to1DIntArray()), equalTo(-1))
}

class GasStation {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            var curStart = 0
            val n = gas.size

            while (curStart < n) {
                var curGas = 0
                var step = 0
                while (step < n) {
                    val idx = (step + curStart) % n
                    curGas += gas[idx] - cost[idx]
                    if (curGas < 0) {
                        curStart += step + 1
                        break
                    }
                    step++
                }
                if (step == n) return curStart
            }

            return -1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}