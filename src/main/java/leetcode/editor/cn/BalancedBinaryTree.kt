package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode

// 平衡二叉树
// 110
/* [3,9,20,null,null,15,7] */

fun main() {
    val result = BalancedBinaryTree.Solution()::isBalanced
    assertThat(result("[3,9,20,null,null,15,7]".toTreeNode()), equalTo(true))
    assertThat(result("[1,2,2,3,3,null,null,4,4]".toTreeNode()), equalTo(false))
}

class BalancedBinaryTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isBalanced(root: TreeNode?): Boolean {
            fun balancedDeep(node: TreeNode?): Int {
                if (node == null) return 0
                var ld = balancedDeep(node.left)
                if (ld < 0) return -1
                var rd = balancedDeep(node.right)
                if (rd < 0) return -1
                if (ld > rd) rd = ld.also { ld = rd }
                if (rd - ld > 1) return -1
                return rd + 1
            }
            return balancedDeep(root) >= 0
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}