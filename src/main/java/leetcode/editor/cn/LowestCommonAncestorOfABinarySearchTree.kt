package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.findNode
import util.toTreeNode2

// 235 二叉搜索树的最近公共祖先
/* [6,2,8,0,4,7,9,null,null,3,5],2,8 */

fun main() {
    val result = LowestCommonAncestorOfABinarySearchTree.Solution()::lowestCommonAncestor
    val tree = "[6,2,8,0,4,7,9,null,null,3,5]".toTreeNode2()
    assertThat(result(tree, tree?.findNode(2), tree?.findNode(8)), equalTo(tree?.findNode(6)))
    assertThat(result(tree, tree?.findNode(2), tree?.findNode(4)), equalTo(tree?.findNode(2)))
}

class LowestCommonAncestorOfABinarySearchTree {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            fun dfs(r: TreeNode, a: TreeNode, b: TreeNode): TreeNode {
                return when {
                    r.`val` == a.`val` || r.`val` == b.`val` -> r
                    r.`val` < a.`val` && r.`val` > b.`val` -> r
                    r.`val` < b.`val` && r.`val` > a.`val` -> r
                    r.`val` < a.`val` && r.`val` < b.`val` -> dfs(r.right!!, a, b)
                    else -> dfs(r.left!!, a, b)
                }
            }

            return dfs(root!!, p!!, q!!)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}