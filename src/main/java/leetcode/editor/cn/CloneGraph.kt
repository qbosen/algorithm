package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import struct.Node
import util.print
import util.toIndexValUndirectedGraph

// 克隆图
// 133
/* [[2,4],[1,3],[2,4],[1,3]] */

fun main() {
    val result = CloneGraph.Solution()::cloneGraph
    val node = "[[2,4],[1,3],[2,4],[1,3]]".toIndexValUndirectedGraph()
    node.print()
    println()
    result(node)!!.print()
}

class CloneGraph {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun cloneGraph(node: Node?): Node? {
            val map = HashMap<Node, Node>()

            fun doClone(n: Node): Node {
                if (map[n] != null) return map[n]!!
                val clone = Node(n.`val`)
                map[n] = clone
                n.neighbors.forEach { clone.neighbors.add(doClone(it)) }
                return clone
            }
            return node?.let(::doClone)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}