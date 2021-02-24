package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.to2DIntList
import util.toTreeNode
import java.util.*
import kotlin.collections.ArrayList

// 二叉树的层序遍历
// 102
/* [3,9,20,null,null,15,7] */

fun main() {
    val result = BinaryTreeLevelOrderTraversal.Solution()::levelOrder
    assertThat(result("[3,9,20,null,null,15,7]".toTreeNode()), equalTo("[[3],[9,20],[15,7]]".to2DIntList()))
}


class BinaryTreeLevelOrderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun levelOrder(root: TreeNode?): List<List<Int>> {
            val res = ArrayList<List<Int>>()
            val cur = LinkedList<TreeNode>()
            val next = LinkedList<TreeNode>()
            if (root == null) return res else next.push(root)

            while (next.isNotEmpty()){
                while(next.isNotEmpty()){
                    cur.push(next.pop())
                }
                val list = ArrayList<Int>()
                for (node in cur) {
                    list.add(node.`val`)
                    node.left?.let { next.push(it) }
                    node.right?.let { next.push(it) }
                }
                res.add(list)
                cur.clear()
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}