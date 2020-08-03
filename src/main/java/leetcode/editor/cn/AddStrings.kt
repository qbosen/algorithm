package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 字符串相加
// 415
/* "0","0" */

fun main() {
    val result = AddStrings.Solution()::addStrings
    assertThat(result("0", "0"), equalTo("0"))
    assertThat(result("123", "888"), equalTo("1011"))
}

class AddStrings {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun addStrings(num1: String, num2: String): String {
            val maxL = Math.max(num1.length, num2.length)
            val res = CharArray(maxL + 1)
            var carry = 0
            for (i in 0 until maxL) {
                val t = get(num1, i) + get(num2, i) + carry
                if (t > 9) {
                    res[res.size - i - 1] = '0' + t - 10
                    carry = 1
                } else {
                    res[res.size - i - 1] = '0' + t
                    carry = 0
                }
            }
            return when (carry) {
                1 -> String(res.also { it[0] = '1' })
                else -> String(res, 1, maxL)
            }
        }

        fun get(num: String, idx: Int): Int {
            return if (idx < num.length) num[num.length - idx - 1] - '0' else 0
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}