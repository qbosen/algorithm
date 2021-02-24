package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode

// 二叉树的最小深度
// 111
/* [3,9,20,null,null,15,7] */

fun main() {
    val result = MinimumDepthOfBinaryTree.Solution()::minDepth
    assertThat(result("[3,9,20,null,null,15,7]".toTreeNode()), equalTo(2))
    assertThat(result("[1,2]".toTreeNode()), equalTo(2))
}

class MinimumDepthOfBinaryTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minDepth(root: TreeNode?): Int {
            fun doMinDepth(node: TreeNode?): Int {
                if (node == null) return Int.MAX_VALUE
                if (node.left == null && node.right == null) return 1
                return 1 + Math.min(doMinDepth(node.left), doMinDepth(node.right))
            }
            return root?.let(::doMinDepth)?:0
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}