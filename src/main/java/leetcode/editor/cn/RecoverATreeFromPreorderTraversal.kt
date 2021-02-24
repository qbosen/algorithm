package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import util.toTreeNode
import java.util.*

// 从先序遍历还原二叉树
// 1028
/* "1-2--3--4-5--6--7" */

fun main() {
    val result = RecoverATreeFromPreorderTraversal.Solution()::recoverFromPreorder
    assertThat(result("1-2--3--4-5--6--7"), equalTo("[1,2,5,3,4,6,7]".toTreeNode()))
    assertThat(result("1-2--3---4-5--6---7"), equalTo("[1,2,5,3,null,6,null,4,null,null,null,7]".toTreeNode()))
    assertThat(result("1-401--349---90--88"), equalTo("[1,401,null,349,88,null,null,90]".toTreeNode()))
}

class RecoverATreeFromPreorderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun recoverFromPreorder(S: String): TreeNode? {
            val path: Deque<TreeNode> = LinkedList()
            var pos = 0
            while (pos < S.length) {
                var level = 0
                while (S[pos] == '-') {
                    level++
                    pos++
                }
                var num = 0
                while (pos < S.length && S[pos].isDigit()) {
                    num = num * 10 + (S[pos] - '0')
                    pos++
                }
                val node = TreeNode(num)
                if(level==path.size){   // 下一层
                    if(path.isNotEmpty()){
                        path.peek().left = node
                    }
                }else{  // 某个节点的右节点
                    while(level!=path.size){
                        path.pop()
                    }
                    path.peek().right = node
                }
                path.push(node)
            }
            return path.last
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}