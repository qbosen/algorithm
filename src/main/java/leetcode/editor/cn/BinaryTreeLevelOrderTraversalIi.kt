package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.to2DIntList
import util.toTreeNode
import java.util.*
import kotlin.collections.ArrayList

// 二叉树的层次遍历 II
// 107
/* [3,9,20,null,null,15,7] */

fun main() {
    val result = BinaryTreeLevelOrderTraversalIi.Solution()::levelOrderBottom
    assertThat(result("[3,9,20,null,null,15,7]".toTreeNode()), equalTo("[[15,7],[9,20],[3]]".to2DIntList()))
}

class BinaryTreeLevelOrderTraversalIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
            val result = LinkedList<ArrayList<Int>>()
            if (root == null) return result

            val queue = LinkedList<TreeNode>()
            queue.push(root)
            while (queue.isNotEmpty()) {
                val level = ArrayList<Int>()
                val size = queue.size
                for (i in 1..size) {
                    val node = queue.poll()
                    level.add(node.`val`)
                    node.left?.let(queue::offer)
                    node.right?.let(queue::offer)
                }
                result.addFirst(level)
            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}