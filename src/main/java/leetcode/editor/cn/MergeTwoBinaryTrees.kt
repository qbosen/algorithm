package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode2

// 617 合并二叉树
/* [1,3,2,5],[2,1,3,null,4,null,7] */

fun main() {
    val result = MergeTwoBinaryTrees.Solution()::mergeTrees
    assertThat(result("[1,3,2,5]".toTreeNode2(), "[2,1,3,null,4,null,7]".toTreeNode2()), equalTo("[3,4,5,5,4,null,7]".toTreeNode2()))
}

class MergeTwoBinaryTrees {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
            return when {
                t1 == null && t2 == null -> null
                t1 == null -> t2
                t2 == null -> t1
                else -> TreeNode(t1.`val` + t2.`val`).apply {
                    left = mergeTrees(t1.left, t2.left)
                    right = mergeTrees(t1.right, t2.right) }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}