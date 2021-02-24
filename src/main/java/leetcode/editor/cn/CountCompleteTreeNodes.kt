package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.toTreeNode2

//222 完全二叉树的节点个数
/* [1,2,3,4,5,6] */

fun main() {
    val result = CountCompleteTreeNodes.Solution()::countNodes
    assertThat(result("[1,2,3,4,5,6]".toTreeNode2()), equalTo(6))
}

class CountCompleteTreeNodes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun countNodes(node: TreeNode?): Int {
            node ?: return 0

            val left = countLevel(node.left)
            val right = countLevel(node.right)
            return if (left == right) {
                countNodes(node.right) + (1 shl left)
            } else {
                countNodes(node.left) + (1 shl right)
            }
        }

        private fun countLevel(node: TreeNode?): Int {
            var level = 0
            var cur = node
            while (cur != null) {
                level++
                cur = cur.left
            }
            return level
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}