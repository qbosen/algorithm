package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.LinkedTreeNode
import struct.desc
import struct.toLinked
import util.toTreeNode2

// 117 填充每个节点的下一个右侧节点指针 II
/* [1,2,3,4,5,null,7] */

fun main() {
    val result = PopulatingNextRightPointersInEachNodeIi.Solution()::connect
    assertThat(result("[1,2,3,4,5,null,7]".toTreeNode2().toLinked()).desc(), equalTo("[1,#,2,3,#,4,5,7,#]"))
}

private typealias Node = LinkedTreeNode

class PopulatingNextRightPointersInEachNodeIi{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    var last: Node? = null
    var nextStart:Node? = null

    fun connect(root: Node?): Node? {
        if (root == null) {
            return null
        }
        var start = root
        while (start != null) {
            last = null
            nextStart = null
            var p = start
            while (p != null) {
                p.left?.run(::handle)
                p.right?.run(::handle)
                p = p.next
            }
            start = nextStart
        }
        return root
    }

    fun handle(p: Node) {
        last?.let{it.next = p}
        if (nextStart == null) {
            nextStart = p
        }
        last = p
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}