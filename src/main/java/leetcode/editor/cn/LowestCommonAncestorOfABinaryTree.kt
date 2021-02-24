package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.findNode
import util.toTreeNode
import java.util.*
import kotlin.collections.HashMap

// 二叉树的最近公共祖先
// 236
/* [3,5,1,6,2,0,8,null,null,7,4],5,1 */

fun main() {
    val result = LowestCommonAncestorOfABinaryTree.Solution()::lowestCommonAncestor
    fun test(tree: TreeNode, n1: Int, n2: Int, target: Int) {
        assertThat(result(tree, tree.findNode(n1), tree.findNode(n2)), equalTo(tree.findNode(target)))
    }
    test("[3,5,1,6,2,0,8,null,null,7,4]".toTreeNode(), 5, 1, 3)
    test("[3,5,1,6,2,0,8,null,null,7,4]".toTreeNode(), 5, 4, 5)
}

class LowestCommonAncestorOfABinaryTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            if (root == null) return null
            val parentMap = HashMap<TreeNode, TreeNode?>()
            val stack = LinkedList<TreeNode>().apply { push(root) }
            while (!stack.isEmpty()) {
                val node = stack.pop()
                node.left?.let { stack.push(it);parentMap[it] = node }
                node.right?.let { stack.push(it);parentMap[it] = node }
            }

            val pset = hashSetOf(p!!)
            var pi = p
            while (pi != null) {
                pi = parentMap[pi]?.also { pset.add(it) }
            }

            pi = q
            while (!pset.contains(pi)) {
                pi = parentMap[pi]
            }
            return pi
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}