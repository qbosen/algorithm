package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode2
import java.util.*

// 501 二叉搜索树中的众数
/* [1,null,2,2] */

fun main() {
    val result = FindModeInBinarySearchTree.Solution()::findMode
    assertThat(result("[1,null,2,2]".toTreeNode2()), equalTo(intArrayOf(2)))
    assertThat(result("[2,2,3,1,2,3,3]".toTreeNode2()), equalTo(intArrayOf(2, 3)))
}

class FindModeInBinarySearchTree {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun findMode(root: TreeNode?): IntArray {
            var maxCount = 0
            var prevI: Int? = null
            var currCount = 0
            val result = LinkedList<Int>()

            fun check(i: Int) {
                if (i == prevI) {
                    currCount++
                } else {
                    currCount = 1
                    prevI = i
                }

                if (currCount == maxCount) result.add(i)
                if (currCount > maxCount) {
                    result.clear()
                    maxCount = currCount
                    result.add(i)
                }

            }

            fun inorder(node: TreeNode?) {
                if (node == null) return
                inorder(node.left)
                check(node.`val`)
                inorder(node.right)
            }

            inorder(root)
            return result.toIntArray()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}