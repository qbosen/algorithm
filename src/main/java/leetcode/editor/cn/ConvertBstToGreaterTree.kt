package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode
import java.util.*

// 538 把二叉搜索树转换为累加树
/* [5,2,13] */

fun main() {
    val result = ConvertBstToGreaterTree.Solution()::convertBST
    assertThat(result("[5,2,13]".toTreeNode()), equalTo("[18,20,13]".toTreeNode()))
    assertThat(result("[10,5,13,1,6,11,18,null,null,null,null,null,12]".toTreeNode()),
            equalTo("[64,75,31,76,70,54,18,null,null,null,null,null,43]".toTreeNode()))
}

class ConvertBstToGreaterTree {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun convertBST(root: TreeNode?): TreeNode? {
            val queue = LinkedList<TreeNode>()
            var node = root
            var sum = 0
            while (node != null || queue.isNotEmpty()) {
                while (node != null) {
                    queue.push(node)
                    node = node.right
                }
                val pop = queue.pop()
                pop.`val` += sum
                sum = pop.`val`
                node = pop.left
            }
            return root
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}