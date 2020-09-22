package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.TreeNode
import util.toTreeNode
import util.toTreeNode2

// 968 监控二叉树
/* [0,0,null,0,0] */

fun main() {
    val result = BinaryTreeCameras.Solution()::minCameraCover
    assertThat(result("[0,0,null,0,0]".toTreeNode()), equalTo( 1))
    assertThat(result("[0,0,null,0,null,0,null,null,0]".toTreeNode2()), equalTo( 2))
}

class BinaryTreeCameras{
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    fun minCameraCover(root: TreeNode?): Int {
        fun dfs(node: TreeNode?):Triple<Int,Int,Int>{
            // a:root必放，整个覆盖,b:无论root，整个覆盖,c:无论root，只覆盖两个子树
            if(node==null) return Triple(Int.MAX_VALUE/2,0,0)
            // a=lc+rc+1 b=min(a, min(la+rb,ra+lb))
            val left = dfs(node.left)
            val right = dfs(node.right)
            val first = left.third + right.third + 1
            val second = Math.min(first, Math.min(left.first+right.second, right.first+left.second))
            val third = Math.min(first, left.second+right.second)
            return Triple(first,second, third)
        }

        return dfs(root).second
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}