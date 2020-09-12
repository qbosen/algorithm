package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.to1DIntArray
import util.toTreeNode
import java.util.*
import kotlin.collections.ArrayList

// 二叉树的层平均值
// 637
/* [3,9,20,15,7] */

fun main() {
    val result = AverageOfLevelsInBinaryTree.Solution()::averageOfLevels
    assertThat(result("[3,9,20,15,7]".toTreeNode()), equalTo(doubleArrayOf(3.0, 14.5, 11.0)))
    assertThat(result("[2147483647,2147483647,2147483647]".toTreeNode()), equalTo(doubleArrayOf(2147483647.0, 2147483647.0)))
}

class AverageOfLevelsInBinaryTree {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun averageOfLevels(root: TreeNode?): DoubleArray {
            if (root == null) return DoubleArray(0)
            val result = ArrayList<Double>()
            val queue = LinkedList<TreeNode>()
            queue.offer(root)
            while (queue.isNotEmpty()) {
                val n = queue.size
                var sum = 0.0
                for (i in 1..n) {
                    val node = queue.poll()
                    sum += node.`val`
                    node.left?.let { queue.offer(it) }
                    node.right?.let { queue.offer(it) }
                }
                result.add(sum / n)
            }
            return result.toDoubleArray()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}