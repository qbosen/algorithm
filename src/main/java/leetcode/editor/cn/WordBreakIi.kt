package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import util.listMatcher
import util.toStringList
import java.util.*


// 140 单词拆分 II
/* "catsanddog",["cat","cats","and","sand","dog"] */

fun main() {
    val result = WordBreakIi.Solution()::wordBreak
    assertThat(result("catsanddog", """["cat","cats","and","sand","dog"]""".toStringList()), listMatcher(
            """["cats and dog","cat sand dog"]""".toStringList()))
    assertThat(result("pineapplepenapple", """["apple", "pen", "applepen", "pine", "pineapple"]""".toStringList()), listMatcher(
            """[ "pine apple pen apple", "pineapple pen apple", "pine applepen apple"]""".toStringList()))
    assertThat(result("catsandog", """["cat","cats","and","sand","dog"]""".toStringList()), listMatcher(
            """[]""".toStringList()))
}

class WordBreakIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun wordBreak(s: String, wordDict: List<String>): List<String> {
            val map: MutableMap<Int, List<List<String>>> = HashMap()
            val wordBreaks = backtrack(s, s.length, HashSet(wordDict), 0, map)
            return wordBreaks.map { it.joinToString(" ") }
        }

        fun backtrack(s: String, length: Int, wordSet: Set<String>, index: Int, map: MutableMap<Int, List<List<String>>>): List<List<String>> {
            if (!map.containsKey(index)) {
                val wordBreaks: MutableList<List<String>> = LinkedList()
                if (index == length) {
                    wordBreaks.add(LinkedList())
                }
                for (i in index + 1..length) {
                    val word = s.substring(index, i)
                    if (wordSet.contains(word)) {
                        val nextWordBreaks = backtrack(s, length, wordSet, i, map)
                        for (nextWordBreak in nextWordBreaks) {
                            val wordBreak = LinkedList(nextWordBreak)
                            wordBreak.offerFirst(word)
                            wordBreaks.add(wordBreak)
                        }
                    }
                }
                map[index] = wordBreaks
            }
            return map[index]!!
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}