package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode2
import java.util.*

// 145 二叉树的后序遍历
/* [1,null,2,3] */

fun main() {
    val result = BinaryTreePostorderTraversal.Solution()::postorderTraversal
    assertThat(result("[1,null,2,3]".toTreeNode2()), equalTo(listOf(3, 2, 1)))
}

class BinaryTreePostorderTraversal {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun postorderTraversal(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()
            val stack = LinkedList<TreeNode>()
            var node: TreeNode? = root
            val result = LinkedList<Int>()
            var prev: TreeNode? = null
            while (node != null || stack.isNotEmpty()) {
                while (node != null) {
                    stack.push(node)
                    node = node.left
                }
                node = stack.pop()
                if (node.right == null || node.right == prev) {
                    result.add(node.`val`)
                    prev = node
                    node = null
                } else {
                    stack.push(node)
                    node = node.right
                }

            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}