package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import java.util.*
import kotlin.collections.ArrayList

//514 自由之路
/* "godding","gd" */

fun main() {
    val result = FreedomTrail.Solution()::findRotateSteps
    assertThat(result("godding", "gd"), equalTo(4))
}

class FreedomTrail {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findRotateSteps(ring: String, key: String): Int {
            val pos = Array<MutableList<Int>>(26) { ArrayList() }
            // 记录ring上每个字符的位置
            for (i in ring.indices) {
                pos[ring[i] - 'a'].add(i)
            }
            // dp[i][j]: ring在j位置时，对准key[i]需要的步数
            // dp[i][j] = min{dp[i-1][k] + min{abs(j-k), n - abs(j-k)} + 1} for k in pos[key[i-1]]: k: 上一次对其的所有可能j位置
            val dp = Array(key.length) { IntArray(ring.length).also { Arrays.fill(it, 0xffffff) } }
            // key[0]在ring的所有位置
            for (j in pos[key[0] - 'a']) {
                dp[0][j] = Math.min(j, ring.length - j) + 1
            }
            // dp
            for (i in 1..key.lastIndex) {
                for (j in pos[key[i] - 'a']) {
                    for (k in pos[key[i - 1] - 'a']) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), ring.length - Math.abs(j - k)) + 1)
                    }
                }
            }
            return dp[key.lastIndex].min()!!
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}