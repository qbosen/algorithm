package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 557 反转字符串中的单词 III
/* "Let's,take,LeetCode,contest" */

fun main() {
    val result = ReverseWordsInAStringIii.Solution()::reverseWords
    assertThat(result("Let's take LeetCode contest"), equalTo("s'teL ekat edoCteeL tsetnoc"))
}

class ReverseWordsInAStringIii {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reverseWords(s: String): String {
            val array = s.toCharArray()
            var s = 0
            var e = 0
            fun reverse(l: Int, r: Int) {
                var l = l
                var r = r
                while (l < r && r < array.size) {
                    array[l] = array[r].also { array[r] = array[l] }
                    l++.also { r-- }
                }
            }


            while (e < array.size) {
                if (array[e] == ' ') {
                    reverse(s, e - 1)
                    s = e + 1
                }
                e++
            }
            reverse(s, e - 1)
            return String(array)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}