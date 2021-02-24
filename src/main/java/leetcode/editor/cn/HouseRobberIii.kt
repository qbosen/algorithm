package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.toTreeNode

// 打家劫舍 III
// 337
/* [3,2,3,null,3,null,1] */

fun main() {
    val result = HouseRobberIii.Solution()::rob
    assertThat(result("[3,2,3,null,3,null,1]".toTreeNode()), equalTo(7))
    assertThat(result("[3,4,5,1,3,null,1]".toTreeNode()), equalTo(9))
}

class HouseRobberIii {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rob(root: TreeNode?): Int {
            fun rob(node: TreeNode?, steal: Boolean): Int {
                if (node == null) return 0
                return if (steal) {
                    node.`val` + rob(node.left, false) + rob(node.right, false)
                } else {
                    Math.max(rob(node.left, false), rob(node.left, true)) + Math.max(rob(node.right, false), rob(node.right, true))
                }
            }
            return Math.max(rob(root, true), rob(root, false))
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}