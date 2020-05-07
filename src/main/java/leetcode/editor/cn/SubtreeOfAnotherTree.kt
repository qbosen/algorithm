package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode
import java.util.ArrayDeque

// 另一个树的子树
// 572
/* [3,4,5,1,2],[4,1,2] */

fun main() {
    val result = SubtreeOfAnotherTree.Solution()::isSubtree
    assertThat(result("[3,4,5,1,2]".toTreeNode(), "[4,1,2]".toTreeNode()), equalTo(true))
    assertThat(result("[3,4,5,1,2,null,null,null,null,0]".toTreeNode(), "[4,1,2]".toTreeNode()), equalTo(false))
}

class SubtreeOfAnotherTree {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
            val stack = ArrayDeque<TreeNode>()
            stack.push(s!!)
            while (!stack.isEmpty()){
                val pop = stack.pop()
                if(isSameTree(pop, t)) return true
                pop.left?.let { stack.push(it) }
                pop.right?.let { stack.push(it) }
            }
            return false
        }

        private fun isSameTree(a: TreeNode?, b: TreeNode?): Boolean {
            if (a === b) return true
            if (a == null || b == null) return false
            return a.`val` == b.`val` && isSameTree(a.left, b.left) && isSameTree(a.right, b.right)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}