package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.toTreeNode

// 二叉树展开为链表
// 114
/* [1,2,5,3,4,null,6] */

fun main() {
    val result = FlattenBinaryTreeToLinkedList.Solution()::flatten

    val mk = { n: TreeNode, i: Int -> TreeNode(i).also { n.right = it } }
    val dummy = TreeNode(-1)
    var node = dummy
    (1..6).forEach { mk(node, it).also { c -> node = c } }
    assertThat("[1,2,5,3,4,null,6]".toTreeNode().apply(result), equalTo(dummy.right))

}

class FlattenBinaryTreeToLinkedList {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun flatten(root: TreeNode?): Unit {
            var cur = root
            if (cur == null) return
            if (cur.left != null) {
                val r = cur.right
                cur.right = cur.left
                cur.left = null
                var ri = cur
                while (ri!!.right != null) ri = ri.right
                ri.right = r
            }
            flatten(cur.right)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}