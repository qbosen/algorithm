package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 数组中的最长山脉
// 845
/* [2,1,4,7,3,2,5] */

fun main() {
    val result = LongestMountainInArray.Solution()::longestMountain
    assertThat(result("[2,1,4,7,3,2,5]".to1DIntArray()), equalTo(5))
}

class LongestMountainInArray{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestMountain(A: IntArray): Int {
        val n: Int = A.size
        var ans = 0
        var left = 0
        while (left + 2 < n) {
            var right = left + 1
            if (A[left] < A[left + 1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++right
                }
                if (right < n - 1 && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++right
                    }
                    ans = Math.max(ans, right - left + 1)
                } else {
                    ++right
                }
            }
            left = right
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}