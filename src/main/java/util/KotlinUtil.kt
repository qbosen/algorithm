package util

import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.*
import struct.ListNode
import struct.Node
import struct.TreeNode
import kotlin.streams.toList

/**
 * @author qiubaisen
 * @date 2020/4/24
 */

fun String.to1DIntArray(): IntArray = IntUtil.parse1DIntArray(this)
fun String.to2DIntArray(): Array<IntArray> = IntUtil.parse2DIntArray(this)
fun String.to2DIntList(): List<List<Int>> = IntUtil.parse2DIntList(this)
fun String.toListNode(): ListNode = IntUtil.parse1DInt2ListNode(this)
fun String.to2DCharArray(): Array<CharArray> = CharUtil.parse2D4String(this)
fun String.toStringList(): List<String> = StringUtil.parse1DList(this)
fun String.to2DStringList(): List<List<String>> = StringUtil.parse2DList(this)
fun String.toListNodeArray(): Array<ListNode?> = IntUtil.parse2DInt2ListNodeArray(this)
fun String.toTreeNode(): TreeNode = IntUtil.parse1DInt2TreeNode(this)
fun String.toIndexValUndirectedGraph(): Node {
    val data = IntUtil.parse2DIntArray(this)
    val map = HashMap<Int, Node>()

    // 值就是idx且唯一
    fun getNode(idx: Int): Node = map.compute(idx) { k, v ->
        v ?: Node().apply { `val` = k;neighbors = ArrayList() }
    }!!
    data.forEachIndexed { i, v ->
        getNode(i + 1).neighbors = v.map { getNode(it) }
    }
    return getNode(1)
}

fun Int.factorial() = (1..this).reduce { a, b -> a * b }

fun TreeNode.print() = TreePrinter.print(this)
fun TreeNode.findNode(value: Int): TreeNode? {
    fun dfs(node: TreeNode?): TreeNode? = when {
        node == null -> null
        node.`val` == value -> node
        else -> dfs(node.left) ?: dfs(node.right)
    }

    return dfs(this)
}

fun Node.print() {
    val visited = HashSet<Int>()
    var toVisit = HashSet<Node>()
    toVisit.add(this)
    while (toVisit.isNotEmpty()) {
        val nextVisit = HashSet<Node>()
        toVisit.forEach { toV ->
            print("[${toV.`val`}] => ")
            toV.neighbors.stream().peek { neib ->
                if (!visited.contains(neib.`val`)) nextVisit.add(neib)
            }.map { it.`val` }.toList().let(::println)
            visited.add(toV.`val`)
        }
        toVisit = nextVisit
    }
}

fun <T> listMatcher(expect: List<T>, matcher: (T) -> Matcher<T> = Matchers::equalTo): Matcher<List<T>> {
    return allOf(hasSize(expect.size), containsInAnyOrder(expect.map { matcher(it) }))
}

fun <T> list2DMatcher(expect: List<List<T>>): Matcher<List<List<T>>> {
    return listMatcher(expect) { list -> listMatcher(list) }
}