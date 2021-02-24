package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode2

// 701 二叉搜索树中的插入操作
/* [4,2,7,1,3],5 */

fun main() {
    val result = InsertIntoABinarySearchTree.Solution()::insertIntoBST
    assertThat(result("[4,2,7,1,3]".toTreeNode2(), 5), equalTo("[4,2,7,1,3,5]".toTreeNode2()))
}

class InsertIntoABinarySearchTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
            fun dfs(node: TreeNode) {
                when {
                    `val` < node.`val` ->
                        node.left?.run { dfs(node.left!!) } ?: run { node.left = TreeNode(`val`) }

                    `val` > node.`val` ->
                        node.right?.run { dfs(node.right!!) } ?: run { node.right = TreeNode(`val`) }
                }
            }
            if (root == null) return TreeNode(`val`)
            dfs(root)
            return root
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}