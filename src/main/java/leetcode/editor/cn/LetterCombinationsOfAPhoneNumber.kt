package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import util.toStringList

// 电话号码的字母组合
// 17
/* "23" */

fun main() {
    val result = LetterCombinationsOfAPhoneNumber.Solution()::letterCombinations
    val expect = """["ad","ae","af","bd","be","bf","cd","ce","cf"]""".toStringList()
    assertThat(result("23"), allOf(hasSize(expect.size), containsInAnyOrder(expect.map(::equalTo))))
    assertThat(result(""), equalTo(emptyList()))
}

class LetterCombinationsOfAPhoneNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun letterCombinations(digits: String): List<String> {
            if (digits.isEmpty()) return emptyList()
            val mapping = HashMap<Char, List<Char>>(8)
            var c = 'a'
            for (i in '2'..'9') {
                when (i) {
                    '7', '9' -> {
                        mapping[i] = listOf(c, c + 1, c + 2, c + 3)
                        c += 4
                    }
                    else -> {
                        mapping[i] = listOf(c, c + 1, c + 2)
                        c += 3
                    }
                }
            }
            val sb = CharArray(digits.length)
            val result = ArrayList<String>()
            fun doMake(idx: Int) {
                for (ch in mapping[digits[idx]]!!) {
                    sb[idx] = ch
                    if (idx >= digits.lastIndex) {
                        result.add(String(sb))
                    } else {
                        doMake(idx + 1)
                    }
                }
            }

            doMake(0)
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}