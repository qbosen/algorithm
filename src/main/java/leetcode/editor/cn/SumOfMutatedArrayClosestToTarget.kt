package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import java.util.*


// 转变数组后最接近目标值的数组和
// 1300
/* [4,9,3],10 */

fun main() {
    val result = SumOfMutatedArrayClosestToTarget.Solution()::findBestValue
    assertThat(result("[4,9,3]".to1DIntArray(),10), equalTo( 3))
}

class SumOfMutatedArrayClosestToTarget{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findBestValue(arr: IntArray, target: Int): Int {
        Arrays.sort(arr)
        val len: Int = arr.size
        var curSum = 0
        for (i in 0 until len) {
            val curAve = (target - curSum) / (len - i)
            if (curAve <= arr[i]) {
                val curAveDou = (target.toDouble() - curSum) / (len - i)
                return if (curAveDou - curAve <= 0.5) {
                    curAve
                } else {
                    curAve + 1
                }
            }
            curSum += arr[i]
        }
        return arr[len - 1]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}