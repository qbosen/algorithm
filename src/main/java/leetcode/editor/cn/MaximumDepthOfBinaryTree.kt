package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode

// 二叉树的最大深度
// 104
/* [3,9,20,null,null,15,7] */

fun main() {
    val result = MaximumDepthOfBinaryTree.Solution()::maxDepth
    assertThat(result("[3,9,20,null,null,15,7]".toTreeNode()), equalTo(3))
}

class MaximumDepthOfBinaryTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxDepth(root: TreeNode?): Int {
            fun doMaxDepth(d: Int, node: TreeNode?): Int {
                if (node == null) return d - 1
                return Math.max(doMaxDepth(d + 1, node.left), doMaxDepth(d + 1, node.right))
            }
            return doMaxDepth(1, root)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}