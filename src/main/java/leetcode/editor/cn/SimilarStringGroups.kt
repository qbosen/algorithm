package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.toStringList

// 839 相似字符串组
/* ["tars","rats","arts","star"] */

fun main() {
    val result = SimilarStringGroups.Solution()::numSimilarGroups
    assertThat(result("""["tars","rats","arts","star"]""".toStringList().toTypedArray()), equalTo(2))
    assertThat(result("""["omv","ovm"]""".toStringList().toTypedArray()), equalTo(1))
}

class SimilarStringGroups {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class UnionFind(n: Int) {
            val parent = IntArray(n) { it }
            val size = IntArray(n) { 1 }
            var count = n
            fun find(i: Int): Int {
                if (parent[i] != i) {
                    parent[i] = find(parent[i])
                }
                return parent[i]
            }

            fun union(i: Int, j: Int): Boolean {
                val ri = find(i)
                val rj = find(j)
                if (ri == rj) return false
                parent[rj] = ri
                size[ri] += size[rj]
                count--
                return true
            }

            fun isConnected(i: Int, j: Int) = find(i) == find(j)
        }

        fun numSimilarGroups(strs: Array<String>): Int {
            val n = strs.size
            val m = strs[0].length
            val uf = UnionFind(n)
            fun check(a: String, b: String): Boolean {
                var count = 0
                for (i in 0 until m) {
                    if (a[i] != b[i]) {
                        count++
                        if (count > 2) return false
                    }
                }
                return true
            }
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    if (uf.isConnected(i, j)) continue
                    if (check(strs[i], strs[j])) uf.union(i, j)
                }
            }
            return uf.count
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}