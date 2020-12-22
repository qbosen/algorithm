package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.to2DIntList
import util.toTreeNode2
import java.util.*
import kotlin.collections.ArrayList

//103 二叉树的锯齿形层序遍历
/* [3,9,20,null,null,15,7] */

fun main() {
    val result = BinaryTreeZigzagLevelOrderTraversal.Solution()::zigzagLevelOrder
    assertThat(result("[3,9,20,null,null,15,7]".toTreeNode2()), equalTo("[[3],[20,9],[15,7]]".to2DIntList()))
}

class BinaryTreeZigzagLevelOrderTraversal {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
            if (root == null) return Collections.emptyList()
            var resverse = false
            val result = LinkedList<List<Int>>()
            var queue = LinkedList<TreeNode>()
            queue.add(root)

            while (queue.isNotEmpty()) {
                val next = LinkedList<TreeNode>()
                val res = LinkedList<Int>()
                while (queue.isNotEmpty()) {
                    val node = queue.poll()
                    if (resverse) res.addFirst(node.`val`)
                    else res.addLast(node.`val`)
                    node.left?.let { next.add(it) }
                    node.right?.let { next.add(it) }
                }
                resverse = !resverse
                result.add(res)
                queue = next
            }

            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}