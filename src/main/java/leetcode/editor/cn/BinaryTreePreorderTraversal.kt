package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode2
import java.util.*
import kotlin.collections.ArrayList

// 144 二叉树的前序遍历
/* [1,null,2,3] */

fun main() {
    val result = BinaryTreePreorderTraversal.Solution()::preorderTraversal
    assertThat(result("[1,null,2,3]".toTreeNode2()), equalTo(listOf(1, 2, 3)))
}

class BinaryTreePreorderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun preorderTraversal(root: TreeNode?): List<Int> {
            val res = ArrayList<Int>()
            if (root == null) return res
            val stack = LinkedList<TreeNode>()
            var node: TreeNode? = root
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    res.add(node.`val`)
                    stack.push(node)
                    node = node.left
                }
                node = stack.pop()
                node = node.right
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}