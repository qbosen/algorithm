package struct

import java.util.*

/**
 * @author qiubaisen
 * @date 2020/9/28
 */
class LinkedTreeNode(var `val`: Int) {
    var left: LinkedTreeNode? = null
    var right: LinkedTreeNode? = null
    var next: LinkedTreeNode? = null
}

fun LinkedTreeNode?.desc(): String {
    val list = LinkedList<LinkedTreeNode?>()
    var node: LinkedTreeNode? = this
    var nextLayer: LinkedTreeNode? = null
    while (node != null || nextLayer != null) {
        list.addLast(node)
        if (node == null) {
            node = nextLayer
            nextLayer = null
        } else {
            if (nextLayer == null) {
                nextLayer = node.left
            }
            if (nextLayer == null) {
                nextLayer = node.right
            }
            node = node.next
        }
    }
    list.addLast(null)
    return list.joinToString(",", "[", "]") { it?.`val`?.toString() ?: "#" }
}

fun TreeNode?.toLinked(): LinkedTreeNode? {
    fun dfs(node: TreeNode?): LinkedTreeNode? {
        if (node == null) return null
        return LinkedTreeNode(node.`val`).apply {
            left = dfs(node.left)
            right = dfs(node.right)
        }
    }
    return dfs(this)
}