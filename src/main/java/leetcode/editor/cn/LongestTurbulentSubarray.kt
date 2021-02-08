package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//978 最长湍流子数组
/* [9,4,2,10,7,8,8,1,9] */

fun main() {
    val result = LongestTurbulentSubarray.Solution()::maxTurbulenceSize
    assertThat(result("[9,4,2,10,7,8,8,1,9]".to1DIntArray()), equalTo(5))
    assertThat(result("[4,8,12,16]".to1DIntArray()), equalTo(2))
    assertThat(result("[100]".to1DIntArray()), equalTo(1))
    assertThat(result("[1,2,1,2]".to1DIntArray()), equalTo(4))
    assertThat(result("[2,1,2]".to1DIntArray()), equalTo(3))
    assertThat(result("[100,100,100]".to1DIntArray()), equalTo(1))
    assertThat(result("[4,5]".to1DIntArray()), equalTo(2))
}

class LongestTurbulentSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxTurbulenceSize(arr: IntArray): Int {
            return if (System.currentTimeMillis() and 1 == 1L) doublePointer(arr) else dynamicProgramming(arr)
        }

        private fun doublePointer(arr: IntArray): Int {
            var l = 0
            var r = 0
            var res = 1
            while (r < arr.size - 1) {
                when {
                    l == r -> {
                        if (arr[r] == arr[r + 1]) l++
                        r++
                    }
                    arr[r - 1] < arr[r] && arr[r] > arr[r + 1] -> r++
                    arr[r - 1] > arr[r] && arr[r] < arr[r + 1] -> r++
                    else -> l = r
                }
                res = Math.max(res, r - l + 1)
            }
            return res
        }

        private fun dynamicProgramming(arr: IntArray): Int {
            if (arr.size <= 1) return 1
            var dp = if (arr[0] == arr[1]) 1 else 2
            var res = dp
            for (i in 2 until arr.size) {
                if (arr[i - 2] > arr[i - 1] && arr[i - 1] < arr[i]) dp++
                else if (arr[i - 2] < arr[i - 1] && arr[i - 1] > arr[i]) dp++
                else dp = if (arr[i - 1] == arr[i]) 1 else 2

                res = Math.max(res, dp)
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}