package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.toTreeNode

// 相同的树
// 100
/* [1,2,3],[1,2,3] */

fun main() {
    val result = SameTree.Solution()::isSameTree
    assertThat(result("[1,2,3]".toTreeNode(), "[1,2,3]".toTreeNode()), equalTo(true))
    assertThat(result("[1,2]".toTreeNode(), "[1,null,2]".toTreeNode()), equalTo(false))
    assertThat(result("[1,2,1]".toTreeNode(), "[1,1,2]".toTreeNode()), equalTo(false))
}

class SameTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
            fun isSameNode(a: TreeNode?, b: TreeNode?): Boolean {
                if (a == null || b == null) return a == b
                return a.`val` == b.`val` && isSameNode(a.left, b.left) && isSameNode(a.right, b.right)
            }

            return isSameNode(p,q)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}