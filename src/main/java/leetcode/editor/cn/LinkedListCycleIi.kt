package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.ListNode

// 环形链表 II
// 142
/* [3,2,0,-4],1 */

fun main() {
    val result = LinkedListCycleIi.Solution()::detectCycle
}

class LinkedListCycleIi {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun detectCycle(head: ListNode?): ListNode? {
            if (head == null) return null
            var fast: ListNode? = head
            var slow: ListNode? = head
            while (fast != null && slow != null) {
                fast = fast.next?.next
                slow = slow.next
                if (fast != null && fast == slow) {
                    var ptr = head
                    while (ptr != slow) {
                        ptr = ptr?.next
                        slow = slow?.next
                    }
                    return ptr
                }
            }
            return null

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}