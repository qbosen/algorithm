package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.ListNode
import util.toListNode

// 234 回文链表
/* [1,2] */

fun main() {
    val result = PalindromeLinkedList.Solution()::isPalindrome
    assertThat(result("[1,2]".toListNode()), equalTo(false))
    assertThat(result("[1,2,2,1]".toListNode()), equalTo(true))
}

class PalindromeLinkedList {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isPalindrome(head: ListNode?): Boolean {
            val dummy = ListNode(0).apply { next = head }
            var slow: ListNode? = dummy
            var fast: ListNode? = dummy
            while (fast?.next != null) {
                slow = slow?.next
                fast = fast.next?.next
            }
            val mid = slow!!
            var last = reverse(mid.next)
            var first = head
            while (last != null && last.`val` == first?.`val`) {
                last = last.next
                first = first.next
            }
            return last == null
        }

        private fun reverse(node: ListNode?): ListNode? {
            var prev: ListNode? = null
            var cur = node
            while (cur != null) {
                val next = cur.next
                cur.next = prev
                prev = cur
                cur = next
            }
            return prev
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}