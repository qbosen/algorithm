package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.to1DIntArray
import util.toTreeNode2

// 106 从中序与后序遍历序列构造二叉树
/* [9,3,15,20,7],[9,15,7,20,3] */

fun main() {
    val result = ConstructBinaryTreeFromInorderAndPostorderTraversal.Solution()::buildTree
    assertThat(result("[9,3,15,20,7]".to1DIntArray(), "[9,15,7,20,3]".to1DIntArray()), equalTo("[3,9,20,null,null,15,7]".toTreeNode2()))
}

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
            fun buildTree(inRange: IntRange, postRange: IntRange): TreeNode? {
                return when {
                    inRange.isEmpty() -> null
                    inRange.first == inRange.last -> TreeNode(inorder[inRange.first])
                    else -> {
                        val root = TreeNode(postorder[postRange.last])
                        val idx = inRange.find { inorder[it] == root.`val` } ?: -1
                        val inLR = inRange.first until idx
                        val postLR = postRange.first..(postRange.first + inLR.last - inLR.first)
                        root.left = buildTree(inLR, postLR)
                        root.right = buildTree(idx + 1..inRange.last, postLR.last + 1 until postRange.last)
                        root
                    }
                }
            }

            return buildTree(inorder.indices, postorder.indices)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}