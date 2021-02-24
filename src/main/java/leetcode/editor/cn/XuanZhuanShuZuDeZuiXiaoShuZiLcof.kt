package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 旋转数组的最小数字
// 剑指 Offer 11
/* [1,3,5] */

fun main() {
    val result = XuanZhuanShuZuDeZuiXiaoShuZiLcof.Solution()::minArray
    assertThat(result("[1,3,5]".to1DIntArray()), equalTo(1))
    assertThat(result("[3,4,5,1,2]".to1DIntArray()), equalTo(1))
    assertThat(result("[2,2,2,0,1]".to1DIntArray()), equalTo(0))
}

class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minArray(numbers: IntArray): Int {
            var low = 0
            var high = numbers.lastIndex
            while (low < high) {
                val pivot = low + (high - low) / 2
                val d = numbers[high] - numbers[pivot]
                when {
                    d > 0 -> high = pivot
                    d < 0 -> low = pivot + 1
                    else -> high -= 1
                }
            }
            return numbers[low]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}