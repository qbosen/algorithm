package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toStringList
import util.toTreeNode

// 257 二叉树的所有路径
/* [1,2,3,null,5] */

fun main() {
    val result = BinaryTreePaths.Solution()::binaryTreePaths
    assertThat(result("[1,2,3,null,5]".toTreeNode()), equalTo("""["1->2->5","1->3"]""".toStringList()))
}

class BinaryTreePaths {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun binaryTreePaths(root: TreeNode?): List<String> {
            if (root == null) return emptyList()
            val result = ArrayList<String>()
            fun dfs(node: TreeNode, path: MutableList<Int>) {
                path.add(node.`val`)
                if (node.left == null && node.right == null) {
                    result.add(path.joinToString("->"))
                    path.removeAt(path.lastIndex)
                    return
                }
                if (node.left != null) dfs(node.left!!, path)
                if (node.right != null) dfs(node.right!!, path)
                path.removeAt(path.lastIndex)
            }
            dfs(root, ArrayList())
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}