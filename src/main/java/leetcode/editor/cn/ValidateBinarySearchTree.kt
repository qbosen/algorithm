package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.toTreeNode
import java.util.ArrayDeque

// 验证二叉搜索树
// 98
/* [2,1,3] */

fun main() {
    val result = ValidateBinarySearchTree.Solution()::isValidBST
    assertThat(result("[2,1,3]".toTreeNode()), equalTo(true))
    assertThat(result("[5,1,4,null,null,3,6]".toTreeNode()), equalTo(false))
}

class ValidateBinarySearchTree {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun isValidBST(root: TreeNode?): Boolean {
            var inorder = Long.MIN_VALUE
            val stack = ArrayDeque<TreeNode>()
            var root = root
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root).let { root = root?.left }
                }
                root = stack.pop()
                if (root!!.`val` <= inorder) return false
                inorder = root!!.`val`.toLong()
                root = root!!.right
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}