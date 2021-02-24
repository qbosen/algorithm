package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import java.util.*
import kotlin.collections.ArrayList


// 单词接龙 II
// 126
/* "hit","cog",["hot","dot","dog","lot","log","cog"] */

fun main() {
    val result = WordLadderIi.Solution()::findLadders
    assertThat(result("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")),
            equalTo(listOf(listOf("hit", "hot", "dot", "dog", "cog"),
                    listOf("hit", "hot", "lot", "log", "cog"))))
}

class WordLadderIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private val wordId = HashMap<String, Int>() // 单词到id的映射
        private val idWord = ArrayList<String>()// id到单词的映射
        private var edges: Array<ArrayList<Int>> = arrayOf() // 图的边

        fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
            var id = 0
            // 将wordList所有单词加入wordId中 相同的只保留一个 // 并为每一个单词分配一个id
            for (word in wordList) {
                if (!wordId.containsKey(word)) {
                    wordId[word] = id++
                    idWord.add(word)
                }
            }
            // 若endWord不在wordList中 则无解
            if (!wordId.containsKey(endWord)) {
                return ArrayList()
            }
            // 把beginWord也加入wordId中
            if (!wordId.containsKey(beginWord)) {
                wordId[beginWord] = id++
                idWord.add(beginWord)
            }

            // 初始化存边用的数组
            edges = Array(idWord.size) { ArrayList<Int>() }
            // 添加边
            for (i in idWord.indices) {
                for (j in i + 1 until idWord.size) {
                    // 若两者可以通过转换得到 则在它们间建一条无向边
                    if (transformCheck(idWord[i], idWord[j])) {
                        edges[i].add(j)
                        edges[j].add(i)
                    }
                }
            }
            val dest = wordId[endWord]!! // 目的ID
            val res: MutableList<List<String>> = ArrayList() // 存答案
            val cost = IntArray(id) // 到每个点的代价
            for (i in 0 until id) {
                cost[i] = Int.MAX_VALUE // 每个点的代价初始化为无穷大
            }

            // 将起点加入队列 并将其cost设为0
            val q: Queue<ArrayList<Int>> = LinkedList()
            val tmpBegin = ArrayList<Int>()
            tmpBegin.add(wordId[beginWord]!!)
            q.add(tmpBegin)
            cost[wordId[beginWord]!!] = 0

            // 开始广度优先搜索
            while (!q.isEmpty()) {
                val now = q.poll()
                val last = now[now.size - 1] // 最近访问的点
                if (last == dest) { // 若该点为终点则将其存入答案res中
                    val tmp = ArrayList<String>()
                    for (index in now) {
                        tmp.add(idWord[index]) // 转换为对应的word
                    }
                    res.add(tmp)
                } else { // 该点不为终点 继续搜索
                    for (i in edges[last].indices) {
                        val to = edges[last][i]
                        // 此处<=目的在于把代价相同的不同路径全部保留下来
                        if (cost[last] + 1 <= cost[to]) {
                            cost[to] = cost[last] + 1
                            // 把to加入路径中
                            val tmp = ArrayList(now)
                            tmp.add(to)
                            q.add(tmp) // 把这个路径加入队列
                        }
                    }
                }
            }
            return res
        }

        // 两个字符串是否可以通过改变一个字母后相等
        fun transformCheck(str1: String, str2: String): Boolean {
            var differences = 0
            var i = 0
            while (i < str1.length && differences < 2) {
                if (str1[i] != str2[i]) {
                    ++differences
                }
                i++
            }
            return differences == 1
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}