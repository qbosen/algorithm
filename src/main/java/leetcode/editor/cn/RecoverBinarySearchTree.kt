package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.toTreeNode

// 恢复二叉搜索树
// 99
/* [1,3,null,null,2] */

fun main() {
    val result = RecoverBinarySearchTree.Solution()::recoverTree
    assertThat("[1,3,null,null,2]".toTreeNode().apply(result), equalTo("[3,1,null,null,2]".toTreeNode()))
    assertThat("[3,1,4,null,null,2]".toTreeNode().apply(result), equalTo("[2,1,4,null,null,3]".toTreeNode()))
}

class RecoverBinarySearchTree {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun recoverTree(root: TreeNode?): Unit {
            var nodeX: TreeNode? = null
            var nodeY: TreeNode? = null
            var prev: TreeNode? = null

            fun inorder(node: TreeNode?) {
                if (node == null) return
                inorder(node.left)
                if (prev != null && node.`val` < prev!!.`val`) {
                    if (nodeX == null) {
                        nodeX = prev
                        nodeY = node
                    } else nodeY = node
                }
                prev = node
                inorder(node.right)
            }

            inorder(root)
            nodeX!!.`val` = nodeY!!.`val`.also { nodeY!!.`val` = nodeX!!.`val` }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}