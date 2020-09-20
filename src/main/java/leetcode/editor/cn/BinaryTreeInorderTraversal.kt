package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode
import java.util.*
import kotlin.collections.ArrayList

// 94 二叉树的中序遍历
/* [1,null,2,3] */

fun main() {
    val result = BinaryTreeInorderTraversal.Solution()::inorderTraversal
    assertThat(result("[1,null,2,null,null,3]".toTreeNode()), equalTo(listOf(1, 3, 2)))
}

class BinaryTreeInorderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun inorderTraversal(root: TreeNode?): List<Int> {
            val result = ArrayList<Int>()
            val queue = LinkedList<TreeNode>()
            var node = root
            while (node != null || queue.isNotEmpty()) {
                while (node != null) {
                    queue.push(node)
                    node = node.left
                }
                val poll = queue.poll()
                result.add(poll.`val`)
                node = poll.right
            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}