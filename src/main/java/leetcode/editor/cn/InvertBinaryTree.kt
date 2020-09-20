package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.toTreeNode

// 226 翻转二叉树
/* [4,2,7,1,3,6,9] */

fun main() {
    val result = InvertBinaryTree.Solution()::invertTree
    assertThat(result("[4,2,7,1,3,6,9]".toTreeNode()), equalTo( "[4,7,2,9,6,3,1]".toTreeNode()))
}

class InvertBinaryTree{
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null) return null
        val left = invertTree(root.left)
        val right = invertTree(root.right)
        root.left = right.also { root.right = left }
        return root
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}