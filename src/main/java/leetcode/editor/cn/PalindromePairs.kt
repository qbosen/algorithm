package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntList

// 回文对
// 336
/* ["abcd","dcba","lls","s","sssll"] */

fun main() {
    val result = PalindromePairs.Solution()::palindromePairs
    assertThat(result(arrayOf("abcd", "dcba", "lls", "s", "sssll")), equalTo("[[0,1],[1,0],[3,2],[2,4]]".to2DIntList()))
    assertThat(result(arrayOf("bat", "tab", "cat")), equalTo("[[0,1],[1,0]] ".to2DIntList()))
}

class PalindromePairs {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun palindromePairs(words: Array<String>): List<List<Int>> {
            val reverseWords: ArrayList<String> = ArrayList()
            val reverseIndex: HashMap<String, Int> = HashMap()

            words.forEachIndexed { i, word ->
                word.reversed().let {
                    reverseWords.add(it)
                    reverseIndex[it] = i
                }
            }

            val result = ArrayList<ArrayList<Int>>()
            for (i in words.indices) {
                val word = words[i]
                if (word.isEmpty()) continue
                for (j in 0..word.length) {
                    if (isPalindrome(word, j, word.lastIndex)) {
                        reverseIndex[word.substring(0 until j)]?.takeIf { it != i }
                                ?.let { result.add(arrayListOf(i, it)) }
                    }
                    if (j != 0 && isPalindrome(word, 0, j - 1)) {
                        reverseIndex[word.substring(j..word.lastIndex)]?.takeIf { it != i }
                                ?.let { result.add(arrayListOf(it, i)) }
                    }
                }
            }
            return result
        }

        fun isPalindrome(string: String, left: Int, right: Int): Boolean {
            for (i in 0 until (right - left + 1) / 2) {
                if (string[left + i] != string[right - i]) {
                    return false
                }
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}