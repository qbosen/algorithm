package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.desc
import struct.LinkedTreeNode as Node
import struct.toLinked
import util.toTreeNode2

// 116 填充每个节点的下一个右侧节点指针
/* [1,2,3,4,5,6,7] */

fun main() {
    val result = PopulatingNextRightPointersInEachNode.Solution()::connect
    assertThat(result("[1,2,3,4,5,6,7]".toTreeNode2().toLinked()).desc(), equalTo("[1,#,2,3,#,4,5,6,7,#]"))
}

class PopulatingNextRightPointersInEachNode{
//leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    fun connect(root: Node?): Node? {
        var last:Node? = null
        var nextLayer :Node? = null

        fun handle(p:Node){
            last?.let { it.next = p }
            nextLayer?:run { nextLayer = p }
            last = p
        }

        if(root ==null) return null
        var layerHead = root
        while(layerHead!=null){   // new layer
            last = null
            nextLayer = null
            var cur = layerHead
            while(cur!=null){
                cur.left?.run(::handle)
                cur.right?.run(::handle)
                cur = cur.next
            }
            layerHead = nextLayer
        }
        return root
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}