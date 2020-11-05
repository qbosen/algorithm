package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.toStringList

// 127 单词接龙
/* "hit","cog",["hot","dot","dog","lot","log","cog"] */

fun main() {
    val result = WordLadder.Solution()::ladderLength
    assertThat(result("hit", "cog", """["hot","dot","dog","lot","log","cog"]""".toStringList()), equalTo(5))
    assertThat(result("hit", "cog", """["hot","dot","dog","lot","log"]""".toStringList()), equalTo(0))
    assertThat(result("leet", "code", """["lest","leet","lose","code","lode","robe","lost"]""".toStringList()), equalTo(6))
}

class WordLadder {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
            val wordSet = HashSet<String>(wordList)
            if (wordSet.isEmpty() || wordSet.contains(endWord).not()) return 0
            val visited = HashSet<String>()

            // 双向bfs
            var beginVisited = HashSet<String>().apply { add(beginWord) }
            var endVisited = HashSet<String>().apply { add(endWord) }
            val nextVisited = HashSet<String>()

            fun tryWordNeighbor(word: String): Boolean {
                val chars = word.toCharArray()
                for (i in chars.indices) {
                    val old = chars[i]
                    for (new in 'a'..'z') {
                        if (new == old) continue
                        chars[i] = new
                        val neighbor = String(chars)
                        when {
                            !wordSet.contains(neighbor) -> Unit             //不在中间表
                            endVisited.contains(neighbor) -> return true    //完成连接
                            !visited.contains(neighbor) -> {                //未遍历的
                                nextVisited.add(neighbor)
                                visited.add(neighbor)
                            }
                        }
                    }
                    chars[i] = old
                }
                return false
            }

            var step = 1
            while (beginVisited.isNotEmpty() && endVisited.isNotEmpty()) {
                // 确保从小的开始扩散
                if (beginVisited.size > endVisited.size) {
                    beginVisited = endVisited.also { endVisited = beginVisited }
                }

                nextVisited.clear()
                for (word in beginVisited) {
                    if (tryWordNeighbor(word)) {
                        return step + 1
                    }
                }
                beginVisited = HashSet(nextVisited)
                step++
            }
            return 0
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}