package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 回文数
// 9
/* 121 */

fun main() {
    val result = PalindromeNumber.Solution()::isPalindrome
    assertThat(result(121), equalTo(true))
    assertThat(result(123321), equalTo(true))
    assertThat(result(-121), equalTo(false))
    assertThat(result(10), equalTo(false))
}

class PalindromeNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isPalindrome(x: Int): Boolean {
            if (x == 0) return true
            if (x < 0 || x % 10 == 0) return false
            var head = x
            var tail = 0
            while (head > tail) {
                tail = tail * 10 + head % 10
                head /= 10
            }
            return tail == head || tail / 10 == head
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}