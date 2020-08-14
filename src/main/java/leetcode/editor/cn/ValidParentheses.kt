package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import java.util.*

// 有效的括号
// 20
/* "()" */

fun main() {
    val result = ValidParentheses.Solution()::isValid
    assertThat(result("()"), equalTo(true))
    assertThat(result("()[]{}"), equalTo(true))
    assertThat(result("(]"), equalTo(false))
    assertThat(result("{[]}"), equalTo(true))
    assertThat(result("([)]"), equalTo(false))
}

class ValidParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isValid(s: String): Boolean {
            val stack = ArrayDeque<Char>()
            for (c in s) {
                when (c) {
                    '(', '[', '{' -> stack.push(c)
                    ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                    ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
                    '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
                }
            }
            return stack.isEmpty()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}