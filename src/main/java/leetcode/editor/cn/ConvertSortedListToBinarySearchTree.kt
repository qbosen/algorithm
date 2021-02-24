package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.ListNode
import struct.TreeNode
import util.toListNode
import util.toTreeNode

// 有序链表转换二叉搜索树
// 109
/* [-10,-3,0,5,9] */

fun main() {
    val result = ConvertSortedListToBinarySearchTree.Solution()::sortedListToBST
    assertThat(result("[-10,-3,0,5,9]".toListNode()), equalTo("[0,-3,9,-10,null,5]".toTreeNode()))
}

class ConvertSortedListToBinarySearchTree {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun sortedListToBST(head: ListNode?): TreeNode? {
            if (head == null) return null
            var global = head   // 标记当前中序遍历的位置
            var itr = head
            var len = 0
            while (itr != null) {
                len++
                itr = itr.next
            }

            fun buildTree(left: Int, right: Int): TreeNode? {
                if (left > right) return null
                val mid = (left + right + 1) / 2    // 这个1只决定了左右谁可能多一个节点
                val node = TreeNode(-1)
                node.left = buildTree(left, mid - 1)
                node.`val` = global!!.`val`
                global = global!!.next
                node.right = buildTree(mid + 1, right)
                return node
            }

            return buildTree(0, len - 1)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}