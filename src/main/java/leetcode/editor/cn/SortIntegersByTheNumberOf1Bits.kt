package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import java.util.*

// 1356 根据数字二进制下 1 的数目排序
/* [0,1,2,3,4,5,6,7,8] */

fun main() {
    val result = SortIntegersByTheNumberOf1Bits.Solution()::sortByBits
    assertThat(result("[0,1,2,3,4,5,6,7,8]".to1DIntArray()), equalTo("[0,1,2,4,8,3,5,6,7]".to1DIntArray()))
    assertThat(result("[1024,512,256,128,64,32,16,8,4,2,1]".to1DIntArray()), equalTo("[1,2,4,8,16,32,64,128,256,512,1024]".to1DIntArray()))
    assertThat(result("[10000,10000]".to1DIntArray()), equalTo("[10000,10000]".to1DIntArray()))
    assertThat(result("[2,3,5,7,11,13,17,19]".to1DIntArray()), equalTo("[2,3,5,17,7,11,13,19]".to1DIntArray()))
    assertThat(result("[10,100,1000,10000]".to1DIntArray()), equalTo("[10,100,10000,1000]".to1DIntArray()))
}

class SortIntegersByTheNumberOf1Bits {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun sortByBits(arr: IntArray): IntArray {
            fun calBit(n: Int): Int {
                var num = n
                var bit = 0
                while (num != 0) {
                    if (num != 0) bit++
                    num = num and num - 1
                }
                return bit
            }

            val comparator = Comparator<Int> { a, b ->
                val res = calBit(a) - calBit(b)
                if (res != 0) res else a - b
            }
            // leetcode不支持prohibited in JVM target 1.6. Recompile with '-jvm-target 1.8'
//            val comparator = Comparator.comparingInt(::calBit).thenComparing(Comparator.naturalOrder())

            val typed = arr.toTypedArray()
            Arrays.sort(typed, comparator)
            return typed.toIntArray()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
