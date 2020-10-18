package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.ListNode
import util.toListNode

// 删除链表的倒数第N个节点
// 19
/* [1,2,3,4,5],2 */

fun main() {
    val result = RemoveNthNodeFromEndOfList.Solution()::removeNthFromEnd
    assertThat(result("[1,2,3,4,5]".toListNode(), 2), equalTo("[1,2,3,5]".toListNode()))
}

class RemoveNthNodeFromEndOfList {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            val dummy = ListNode(0).apply { next = head }
            var first = head
            var second: ListNode? = dummy
            for (i in 0 until n) {
                first = first!!.next
            }
            while (first != null) {
                first = first.next
                second = second!!.next
            }
            second!!.next = second.next!!.next
            return dummy.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}