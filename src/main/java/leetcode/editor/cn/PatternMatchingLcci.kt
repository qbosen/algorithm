package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 模式匹配
// 面试题 16.18
/* "abba","dogcatcatdog" */

fun main() {
    val result = PatternMatchingLcci.Solution()::patternMatching
    assertThat(result("abba", "dogcatcatdog"), equalTo(true))
    assertThat(result("abba", "dogcatcatfish"), equalTo(false))
    assertThat(result("aaaa", "dogcatcatdog"), equalTo(false))
    assertThat(result("abba", "dogdogdogdog"), equalTo(true))
}

class PatternMatchingLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun patternMatching(pattern: String, value: String): Boolean {
            if (pattern.isEmpty()) return value.isEmpty()
            var pattern = pattern
            var count_a = 0
            var count_b = 0
            for (ch in pattern.toCharArray()) {
                if (ch == 'a') {
                    ++count_a
                } else {
                    ++count_b
                }
            }
            if (count_a < count_b) {
                val temp = count_a
                count_a = count_b
                count_b = temp
                val array = pattern.toCharArray()
                for (i in array.indices) {
                    array[i] = if (array[i] == 'a') 'b' else 'a'
                }
                pattern = String(array)
            }
            if (value.isEmpty()) {
                return count_b == 0
            }
            if (pattern.isEmpty()) {
                return false
            }

            var len_a = 0
            while (count_a * len_a <= value.length) {
                val rest: Int = value.length - count_a * len_a
                if (count_b == 0 && rest == 0 || count_b != 0 && rest % count_b == 0) {
                    val len_b = if (count_b == 0) 0 else rest / count_b
                    var pos = 0
                    var correct = true
                    var value_a = ""
                    var value_b = ""
                    for (ch in pattern.toCharArray()) {
                        if (ch == 'a') {
                            val sub = value.substring(pos, pos + len_a)
                            if (value_a.length == 0) {
                                value_a = sub
                            } else if (value_a != sub) {
                                correct = false
                                break
                            }
                            pos += len_a
                        } else {
                            val sub = value.substring(pos, pos + len_b)
                            if (value_b.length == 0) {
                                value_b = sub
                            } else if (value_b != sub) {
                                correct = false
                                break
                            }
                            pos += len_b
                        }
                    }
                    if (correct && value_a != value_b) {
                        return true
                    }
                }
                ++len_a
            }

            return false
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}