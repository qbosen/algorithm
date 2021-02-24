package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode

// 路径总和
// 112
/* [5,4,8,11,null,13,4,7,2,null,null,null,1],22 */

fun main() {
    val result = PathSum.Solution()::hasPathSum
    assertThat(result("[5,4,8,11,null,13,4,7,2,null,null,null,null,1]".toTreeNode(), 22), equalTo(true))
    assertThat(result("[5,4,8,11,null,13,4,7,2,null,null,null,null,1]".toTreeNode(), 18), equalTo(true))
    assertThat(result("[5,4,8,11,null,13,4,7,2,null,null,null,null,1]".toTreeNode(), 17), equalTo(false))
}

class PathSum {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
            return if (root == null) false else lookSum(root, sum, 0)
        }

        fun lookSum(node: TreeNode, sum: Int, curSum: Int): Boolean {
            if (node.left == null && node.right == null) return sum == curSum + node.`val`
            return (node.left != null && lookSum(node.left!!, sum, curSum + node.`val`)) ||
                    (node.right != null && lookSum(node.right!!, sum, curSum + node.`val`))
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}