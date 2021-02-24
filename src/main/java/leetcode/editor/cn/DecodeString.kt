package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import java.util.*

// 字符串解码
// 394
/* "3[a]2[bc]" */

fun main() {
    val result = DecodeString.Solution()::decodeString
    assertThat(result("3[a]2[bc]"), equalTo("aaabcbc"))
    assertThat(result("3[a2[c]]"), equalTo("accaccacc"))
    assertThat(result("2[abc]3[cd]ef"), equalTo("abcabccdcdcdef"))
    assertThat(result("10[a2[c]]"), equalTo("accaccaccaccaccaccaccaccaccacc"))
    assertThat(result("2[a2[3[b2[c]]]d]"), equalTo("abccbccbccbccbccbccdabccbccbccbccbccbccd"))

}

class DecodeString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun decodeString(s: String): String {
            val stack = LinkedList<Char>()
            fun getK(): Int {
                var pow = 1
                var res = 0
                while (stack.isNotEmpty() && stack.peek().isDigit()) {
                    res += (stack.pop() - '0') * pow
                    pow *= 10
                }
                return res
            }
            for (i in s) {
                when (i) {
                    ']' -> {
                        val tmp = LinkedList<Char>()
                        var c = stack.pop()
                        while (c != '[') {
                            tmp.addFirst(c)
                            c = stack.pop()
                        }
                        repeat(getK()) {
                            tmp.forEach(stack::push)
                        }
                    }
                    else -> stack.push(i)
                }
            }
            val res = StringBuilder(stack.size)
            while (stack.isNotEmpty()) {
                res.append(stack.pollLast())
            }
            return res.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}