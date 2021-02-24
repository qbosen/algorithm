package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.contains
import util.listMatcher
import util.to2DIntArray
import util.to2DIntList

//1489 找到最小生成树里的关键边和伪关键边
/* 5,[[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]] */

fun main() {
    val result = FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree.Solution()::findCriticalAndPseudoCriticalEdges
    assertThat(
        result(5, "[[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]".to2DIntArray()),
        allOf(contains("[[0,1],[2,3,4,5]]".to2DIntList().map { listMatcher(it) }))
    )
    assertThat(
        result(4, "[[0,1,1],[1,2,1],[2,3,1],[0,3,1]]".to2DIntArray()),
        allOf(contains("[[],[0,1,2,3]]".to2DIntList().map { listMatcher(it) }))
    )
    assertThat(
        result(6, "[[0,1,1],[1,2,1],[0,2,1],[2,3,4],[3,4,2],[3,5,2],[4,5,2]]".to2DIntArray()),
        allOf(contains("[[3],[0,1,2,4,5,6]]".to2DIntList().map { listMatcher(it) }))
    )
}

class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class UnionFind(val n: Int) {
            val parent = IntArray(n) { it }
            val size = IntArray(n) { 1 }
            var count = n
                private set

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
                if (size[ri] < size[rj]) {
                    size[ri] = size[rj].also { size[rj] = size[ri] }
                }
                parent[rj] = ri
                size[ri] += size[rj]
                count--
                return true
            }
        }

        fun findCriticalAndPseudoCriticalEdges(n: Int, edges: Array<IntArray>): List<List<Int>> {
            val m = edges.size
            val newEdges = Array(m) { IntArray(4) }
            for (i in 0 until m) {
                for (j in 0 until 3) {
                    newEdges[i][j] = edges[i][j]
                }
                newEdges[i][3] = i  // 对原边的映射
            }
            newEdges.sortBy { it[2] }

            // 计算mst的权重
            val ufStd = UnionFind(n)
            var value = 0
            for (i in 0 until m) {
                if (ufStd.union(newEdges[i][0], newEdges[i][1])) {
                    value += newEdges[i][2]
                }
            }

            val result = listOf(ArrayList(), ArrayList<Int>())

            for (i in 0 until m) {
                // 关键边判断
                var uf = UnionFind(n)
                var v = 0
                for (j in 0 until m) {
                    // 除开i边的mst
                    if (j != i && uf.union(newEdges[j][0], newEdges[j][1])) {
                        v += newEdges[j][2]
                    }
                }
                // 删除边后 连通性变化 或 权重严格增加，关键边
                if (uf.count != 1 || (uf.count == 1 && v > value)) {
                    result[0].add(newEdges[i][3])
                    continue
                }
                // 可能出现在在某些mst的边->有此边的mst权重不变，且该边不是关键边->伪关键边
                uf = UnionFind(n)
                uf.union(newEdges[i][0], newEdges[i][1])
                v = newEdges[i][2]
                for (j in 0 until m) {
                    // 除开i边的mst
                    if (j != i && uf.union(newEdges[j][0], newEdges[j][1])) {
                        v += newEdges[j][2]
                    }
                }
                if (v == value) {
                    result[1].add(newEdges[i][3])
                }
            }

            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}