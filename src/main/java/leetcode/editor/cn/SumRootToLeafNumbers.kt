package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode2

// 129 求根到叶子节点数字之和
/* [1,2,3] */

fun main() {
    val result = SumRootToLeafNumbers.Solution()::sumNumbers
    assertThat(result("[1,2,3]".toTreeNode2()), equalTo(25))
    assertThat(result("[4,9,0,5,1]".toTreeNode2()), equalTo(1026))
}

class SumRootToLeafNumbers {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun sumNumbers(root: TreeNode?): Int {
            fun cal(prev: Int, node: TreeNode): Int {
                val next = prev * 10 + node.`val`
                if (node.left == null && node.right == null) {
                    return next
                }
                return (node.left?.let { cal(next, it) } ?: 0) + (node.right?.let { cal(next, it) } ?: 0)
            }
            return root?.let { cal(0, it) } ?: 0
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}