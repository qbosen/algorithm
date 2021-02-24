package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 941 有效的山脉数组
/* [2,1] */

fun main() {
    val result = ValidMountainArray.Solution()::validMountainArray
    assertThat(result("[2,1]".to1DIntArray()), equalTo(false))
    assertThat(result("[3,5,5]".to1DIntArray()), equalTo(false))
    assertThat(result("[0,3,2,1]".to1DIntArray()), equalTo(true))
    assertThat(result("[14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3]".to1DIntArray()), equalTo(false))
}

class ValidMountainArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun validMountainArray(A: IntArray): Boolean {
            if (A.size < 3) return false
            var found = false
            for (i in 1 until A.lastIndex) {
                if (!found && A[i] > A[i - 1] && A[i] > A[i + 1]) {
                    found = true
                }

                if (!found && A[i - 1] >= A[i]) return false
                if (found && A[i + 1] >= A[i]) return false
            }
            return found
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}