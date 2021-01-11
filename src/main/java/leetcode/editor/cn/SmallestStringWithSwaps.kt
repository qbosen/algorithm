package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntList
import util.to2DStringList
import java.util.*
import kotlin.collections.HashMap

//1202 交换字符串中的元素
/* "dcab",[[0,3],[1,2]] */

fun main() {
    val result = SmallestStringWithSwaps.Solution()::smallestStringWithSwaps
    assertThat(result("dcab", "[[0,3],[1,2]]".to2DIntList()), equalTo("bacd"))
    assertThat(result("dcab", "[[0,3],[1,2],[0,2]]".to2DIntList()), equalTo("abcd"))
    assertThat(result("cba", "[[0,1],[1,2]]".to2DIntList()), equalTo("abc"))
}

class SmallestStringWithSwaps {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
            val uf = IntArray(s.length) { it }
            fun find(i: Int): Int {
                if (uf[i] != i) {
                    uf[i] = find(uf[i])
                }
                return uf[i]
            }

            fun union(a: Int, b: Int) {
                uf[find(a)] = find(b)
            }

            pairs.forEach { (a, b) -> union(a, b) }
            val group = HashMap<Int, PriorityQueue<Int>>()
            val comparator = Comparator<Int> { a, b -> s[a] - s[b] }
            uf.indices.forEach { i -> group.computeIfAbsent(find(i)) { PriorityQueue(comparator) }.offer(i) }

            return String(CharArray(s.length) { s[group[find(it)]!!.poll()] })
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}