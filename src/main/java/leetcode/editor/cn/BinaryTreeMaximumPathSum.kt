package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode

// 二叉树中的最大路径和
// 124
/* [1,2,3] */

fun main() {
    val result = BinaryTreeMaximumPathSum.Solution()::maxPathSum
    assertThat(result("[1,2,3]".toTreeNode()), equalTo(6 ))
}

class BinaryTreeMaximumPathSum{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    var maxSum = Int.MIN_VALUE
    fun  maxPathSum(root: TreeNode?):Int {
        maxGain(root)
        return maxSum
    }

    fun maxGain(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        val leftGain = Math.max(maxGain(node.left), 0)
        val rightGain = Math.max(maxGain(node.right), 0)

        val priceNewpath: Int = node.`val` + leftGain + rightGain

        maxSum = Math.max(maxSum, priceNewpath)

        return node.`val` + Math.max(leftGain, rightGain)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}