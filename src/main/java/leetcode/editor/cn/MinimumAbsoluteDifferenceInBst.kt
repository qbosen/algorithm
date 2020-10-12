package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode2

// 530 二叉搜索树的最小绝对差
/* [1,null,3,2] */

fun main() {
    val result = MinimumAbsoluteDifferenceInBst.Solution()::getMinimumDifference
    assertThat(result("[1,null,3,2]".toTreeNode2()), equalTo(1))
    assertThat(result("[543,384,652,null,445,null,699]".toTreeNode2()), equalTo(47))
    assertThat(result("[1564,1434,3048,1,null,null,3184]".toTreeNode2()), equalTo(130))
}

class MinimumAbsoluteDifferenceInBst {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun getMinimumDifference(root: TreeNode?): Int {
            if (root == null) return 0
            return differ(root).third
        }

        // min max result
        private fun differ(node: TreeNode): Triple<Int, Int, Int> {
            return when {
                node.left == null && node.right == null -> Triple(node.`val`, node.`val`, Int.MAX_VALUE)
                node.right == null -> {
                    val left = differ(node.left!!)
                    Triple(left.first, node.`val`, Math.min(Math.abs(node.`val` - left.second), left.third))
                }
                node.left == null -> {
                    val right = differ(node.right!!)
                    Triple(node.`val`, right.second, Math.min(Math.abs(node.`val` - right.first), right.third))
                }
                else -> {
                    val left = differ(node.left!!)
                    val right = differ(node.right!!)
                    Triple(left.first, right.second, minOf(Math.abs(node.`val` - left.second), Math.abs(node.`val` - right.first), left.third, right.third))
                }
            }
        }
        private fun minOf(a:Int, vararg  other:Int):Int{
            var min = a
            for(i in other){
                min = Math.min(min, i)
            }
            return min
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}