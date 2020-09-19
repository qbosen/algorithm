package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode

// 404 左叶子之和
/* [3,9,20,null,null,15,7] */

fun main() {
    val result = SumOfLeftLeaves.Solution()::sumOfLeftLeaves
    assertThat(result("[3,9,20,null,null,15,7]".toTreeNode()), equalTo(24))
}

class SumOfLeftLeaves {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun sumOfLeftLeaves(root: TreeNode?): Int {
            if (root == null) return 0
            var sum = 0
            fun dfs(node: TreeNode, isLeft: Boolean) {
                if (isLeft && node.left == null && node.right == null) sum += node.`val`
                node.left?.let { dfs(it, true) }
                node.right?.let { dfs(it, false) }
            }
            dfs(root, false)
            return sum
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}