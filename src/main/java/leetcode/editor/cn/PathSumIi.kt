package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import struct.TreeNode
import util.list2DMatcher
import util.to2DIntList
import util.toTreeNode2
import java.util.*
import kotlin.collections.ArrayList

// 路径总和 II
// 113
/* [5,4,8,11,null,13,4,7,2,null,null,5,1],22 */

fun main() {
    val result = PathSumIi.Solution()::pathSum
    assertThat(result("[5,4,8,11,null,13,4,7,2,null,null,5,1]".toTreeNode2(), 22), list2DMatcher("[[5,4,11,2],[5,8,4,5]]".to2DIntList()))
}

class PathSumIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
            val temp = LinkedList<Int>()
            val result = ArrayList<List<Int>>()
            fun dfs(node: TreeNode?, count: Int) {
                if (node == null) {
                    return
                }
                if (node.left == null && node.right == null && count == node.`val`) {
                    temp.addLast(node.`val`)
                    result.add(ArrayList(temp))
                    temp.removeAt(temp.lastIndex)
                    return
                }

                temp.addLast(node.`val`)
                dfs(node.left, count - node.`val`)
                dfs(node.right, count - node.`val`)
                temp.removeAt(temp.lastIndex)
            }
            dfs(root, sum)
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}