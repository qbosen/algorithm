package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DDoubleArray
import util.to2DStringList

//399 除法求值
/* [["a","b"],["b","c"]],[2.0,3.0],[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]] */

fun main() {
    val result = EvaluateDivision.Solution()::calcEquation
    assertThat(
        result(
            """[["a","b"],["b","c"]]""".to2DStringList(),
            "[2.0,3.0]".to1DDoubleArray(),
            """[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]""".to2DStringList()
        ).toTypedArray(),
        arrayContaining(
            "[6.00000,0.50000,-1.00000,1.00000,-1.00000]".to1DDoubleArray().map { closeTo(it, 1E-5) })
    )

    assertThat(
        result(
            """[["a","b"],["b","c"],["bc","cd"]]""".to2DStringList(),
            "[1.5,2.5,5.0]".to1DDoubleArray(),
            """[["a","c"],["c","b"],["bc","cd"],["cd","bc"]]""".to2DStringList()
        ).toTypedArray(),
        arrayContaining(
            "[3.75000,0.40000,5.00000,0.20000]".to1DDoubleArray().map { closeTo(it, 1E-5) })
    )
    assertThat(
        result(
            """[["a","b"]]""".to2DStringList(),
            "[0.5]".to1DDoubleArray(),
            """[["a","b"],["b","a"],["a","c"],["x","y"]]""".to2DStringList()
        ).toTypedArray(),
        arrayContaining(
            "[0.50000,2.00000,-1.00000,-1.00000]".to1DDoubleArray().map { closeTo(it, 1E-5) })
    )
    assertThat(
        result(
            """[["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]]""".to2DStringList(),
            "[3.0,4.0,5.0,6.0]".to1DDoubleArray(),
            """[["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]]""".to2DStringList()
        ).toTypedArray(),
        arrayContaining(
            "[360.0,0.00833,20.0,1.0,-1.0,-1.0]".to1DDoubleArray().map { closeTo(it, 1E-5) })
    )
}

class EvaluateDivision {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
            val uf = HashMap<String, String>()
            val weight = HashMap<String, Double>()

            fun find(s: String): String {
                if (uf[s] == null) {
                    weight[s] = 1.0
                    uf[s] = s
                }
                if (uf[s] != s) {
                    val origin = uf[s]!!
                    uf[s] = find(origin)
                    weight[s] = weight[s]!! * weight[origin]!!
                }
                return uf[s]!!
            }

            fun union(a: String, b: String, multi: Double) {
                val ar = find(a)
                val br = find(b)
                if(ar == br) return
                weight[ar] = multi * weight[b]!! / weight[a]!!
                uf[ar] = br
            }

            for (i in values.indices) {
                val (a, b) = equations[i]
                union(a, b, values[i])
            }

            val result = DoubleArray(queries.size) { -1.0 }
            for (i in queries.indices) {
                val (a, b) = queries[i]
                if (uf[a] == null || uf[b] == null || find(a) != find(b)) continue
                result[i] = weight[a]!! / weight[b]!!
            }

            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}