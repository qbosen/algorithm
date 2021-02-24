package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.to1DIntArray
import util.toTreeNode

// 从前序与中序遍历序列构造二叉树
// 105
/* [3,9,20,15,7],[9,3,15,20,7] */

fun main() {
    val result = ConstructBinaryTreeFromPreorderAndInorderTraversal.Solution()::buildTree
    assertThat(result("[3,9,20,15,7]".to1DIntArray(), "[9,3,15,20,7]".to1DIntArray()), equalTo("[3,9,20,null,null,15,7]".toTreeNode()))
    assertThat(result("[1,2,3]".to1DIntArray(), "[3,2,1]".to1DIntArray()), equalTo("[1,2,null,3]".toTreeNode()))
}

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            if (preorder.isEmpty()) return null

            fun doBuildTree(ps: Int, pe: Int, ins: Int, ine: Int): TreeNode? = when (pe) {
                ps -> null
                ps + 1 -> TreeNode(preorder[ps])
                else -> {
                    val root = TreeNode(preorder[ps])
                    val leftSize = (ins..ine).find { inorder[it] == preorder[ps] }!! - ins
                    root.left = doBuildTree(ps + 1, ps + leftSize + 1, ins, ins + leftSize)
                    root.right = doBuildTree(ps + leftSize + 1, pe, ins + leftSize + 1, ine)
                    root
                }
            }

            return doBuildTree(0, preorder.size, 0, inorder.size)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}