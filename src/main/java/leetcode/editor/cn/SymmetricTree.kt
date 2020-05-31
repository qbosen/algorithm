package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.toTreeNode

// 对称二叉树
// 101
/* [1,2,2,3,4,4,3] */

fun main() {
    val result = SymmetricTree.Solution()::isSymmetric
    assertThat(result("[1,2,2,3,4,4,3]".toTreeNode()), equalTo(true))
    assertThat(result("[1,2,2,null,3,null,3]".toTreeNode()), equalTo(false))
}

class SymmetricTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isSymmetric(root: TreeNode?): Boolean {
            fun check(p: TreeNode?, q: TreeNode?): Boolean {
                return when {
                    p == null && q == null -> true
                    p == null || q == null -> false
                    else -> p.`val` == q.`val` && check(p.left, q.right) && check(p.right, q.left)
                }
            }

            return check(root, root)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}