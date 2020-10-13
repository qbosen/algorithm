package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.ListNode
import util.toListNode

// 24 两两交换链表中的节点
/* [1,2,3,4] */

fun main() {
    val result = SwapNodesInPairs.Solution()::swapPairs
    assertThat(result("[1,2,3,4]".toListNode()), equalTo("[2,1,4,3]".toListNode()))
}

class SwapNodesInPairs{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if(head == null) return null
        val dummy = ListNode(-1).also { it.next = head }
        var first = dummy
        while(first.next!=null && first.next?.next!=null){
            val second = first.next!!
            val third = second.next!!
            val next = third.next
            first.next = third
            third.next = second
            second.next = next
            first = second
        }
        return dummy.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}