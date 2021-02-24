package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

//567 字符串的排列
/* "ab","eidbaooo" */

fun main() {
    val result = PermutationInString.Solution()::checkInclusion
    assertThat(result("ab", "eidbaooo"), equalTo(true))
    assertThat(result("ab", "eidboaoo"), equalTo(false))
}

class PermutationInString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun checkInclusion(s1: String, s2: String): Boolean {
            val pattern = s1.toCharArray()
            val text = s2.toCharArray()

            val pLen: Int = s1.length
            val tLen: Int = s2.length

            val pFreq = IntArray(26)
            val winFreq = IntArray(26)

            for (i in 0 until pLen) {
                pFreq[pattern[i] - 'a']++
            }

            var pCount = 0
            for (i in 0..25) {
                if (pFreq[i] > 0) {
                    pCount++
                }
            }

            var left = 0
            var right = 0
            // 当滑动窗口中的某个字符个数与 s1 中对应相等的时候才计数
            // 当滑动窗口中的某个字符个数与 s1 中对应相等的时候才计数
            var winCount = 0
            while (right < tLen) {
                if (pFreq[text[right] - 'a'] > 0) {
                    winFreq[text[right] - 'a']++
                    if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a']) {
                        winCount++
                    }
                }
                right++
                while (pCount == winCount) {
                    if (right - left == pLen) {
                        return true
                    }
                    if (pFreq[text[left] - 'a'] > 0) {
                        winFreq[text[left] - 'a']--
                        if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a']) {
                            winCount--
                        }
                    }
                    left++
                }
            }
            return false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}