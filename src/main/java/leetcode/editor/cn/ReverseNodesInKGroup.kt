package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.ListNode
import util.toListNode

// K 个一组翻转链表
// 25
/* [1,2,3,4,5],2 */

fun main() {
    val result = ReverseNodesInKGroup.Solution()::reverseKGroup
    assertThat(result("[1,2,3,4,5]".toListNode(), 2), equalTo("[2,1,4,3,5]".toListNode()))
    assertThat(result("[1,2,3,4,5]".toListNode(), 3), equalTo("[3,2,1,4,5]".toListNode()))
}

class ReverseNodesInKGroup {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
            val dummy = ListNode(-1).apply { next = head }
            var pre:ListNode? = dummy
            var end: ListNode? = dummy

            while (end?.next != null) {
                repeat(k) { end = end?.next }
                if (end == null) break
                val start = pre!!.next
                val next = end!!.next
                end!!.next = null
                pre.next = reverseToEnd(start)
                start?.next = next

                pre = start
                end = pre
            }

            return dummy.next
        }

        fun reverseToEnd(node: ListNode?): ListNode? {
            var pre: ListNode? = null
            var cur = node
            while (cur != null) {
                val next = cur.next
                cur.next = pre
                pre = cur
                cur = next
            }
            return pre
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}