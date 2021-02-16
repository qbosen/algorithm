package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 561 数组拆分 I
/* [1,4,3,2] */

fun main() {
    val result = ArrayPartitionI.Solution()::arrayPairSum
    assertThat(result("[1,4,3,2]".to1DIntArray()), equalTo(4))
}

class ArrayPartitionI {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun arrayPairSum(nums: IntArray): Int {
            nums.sort()
            var res = 0
            for(i in nums.indices step 2){
                res += nums[i]
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}