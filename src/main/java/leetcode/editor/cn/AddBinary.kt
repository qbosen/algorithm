package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 二进制求和
// 67
/* "11","1" */

fun main() {
    val result = AddBinary.Solution()::addBinary
    assertThat(result("11", "1"), equalTo("100"))
    assertThat(result("1010", "1011"), equalTo("10101"))
}

class AddBinary {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun addBinary(a: String, b: String): String {
            val ans = StringBuffer()

            val n: Int = Math.max(a.length, b.length)
            var carry = 0
            for (i in 0 until n) {
                carry += if (i < a.length) a[a.length - 1 - i] - '0' else 0
                carry += if (i < b.length) b[b.length - 1 - i] - '0' else 0
                ans.append(carry % 2)
                carry /= 2
            }

            if (carry > 0) {
                ans.append('1')
            }
            ans.reverse()

            return ans.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}