package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.ListNode
import util.toListNode

// 143 重排链表
/* [1,2,3,4] */

fun main() {
    val result = ReorderList.Solution()::reorderList
    assertThat("[1,2,3,4]".toListNode().apply(result), equalTo("[1,4,2,3]".toListNode()))
    assertThat("[1,2,3,4,5]".toListNode().apply(result), equalTo("[1,5,2,4,3]".toListNode()))
}

class ReorderList {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reorderList(head: ListNode?): Unit {
            val dummy = ListNode(0).also { it.next = head }
            var fast: ListNode? = dummy
            var slow: ListNode? = dummy
            while (fast?.next != null) {    // 靠左
                fast = fast.next?.next
                slow = slow?.next
            }
            val mid = slow!!
            val last = reverseList(mid.next)
            mid.next = null
            mergeList(dummy.next,last)
        }

        private fun mergeList(l1: ListNode?, l2: ListNode?) {
            var l1 = l1
            var l2 = l2
            var  l1Tmp:ListNode?
            var  l2Tmp:ListNode?
            while (l1 != null && l2 != null) {
                l1Tmp = l1.next
                l2Tmp = l2.next

                l1.next = l2
                l1 = l1Tmp

                l2.next = l1
                l2 = l2Tmp
            }
        }

        private fun reverseList(head: ListNode?): ListNode? {
            var prev: ListNode? = null
            var curr = head
            while (curr != null) {
                val nextTemp = curr.next
                curr.next = prev
                prev = curr
                curr = nextTemp
            }
            return prev
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}