package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.ListNode
import util.to1DIntArray

// 141 环形链表
/* [3,2,0,-4],1 */

fun main() {
    val result = LinkedListCycle.Solution()::hasCycle
    assertThat(result(buildListCycle("[3,2,0,-4]", 1)), equalTo(true))
    assertThat(result(buildListCycle("[1,2]", 1)), equalTo(true))
    assertThat(result(buildListCycle("[1]", -1)), equalTo(false))

}

fun buildListCycle(nodes: String, cycle: Int): ListNode? {
    val dummy = ListNode(-1)
    val last = nodes.to1DIntArray().fold(dummy) { node, i ->
        ListNode(i).also { node.next = it }
    }
    if (cycle == -1) return dummy.next
    var cycleNode: ListNode? = dummy.next
    var cycle = cycle
    while (cycle > 0) {
        cycleNode = cycleNode!!.next
        cycle--
    }
    last.next = cycleNode
    return dummy.next
}

class LinkedListCycle {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun hasCycle(head: ListNode?): Boolean {
            if (head == null) return false
            var fast: ListNode? = head
            var slow: ListNode? = head
            while (fast != null && slow != null) {
                fast = fast.next?.next
                slow = slow.next
                if (fast != null && fast == slow) {
                    return true
                }
            }
            return false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}