package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat

import org.hamcrest.Matchers.equalTo
import struct.ListNode
import util.toListNode


// 两数相加
// 2
/* [2,4,3],[5,6,4] */

fun main() {
    val result = AddTwoNumbers.Solution()::addTwoNumbers
    assertThat(result("[2,4,3]".toListNode(),"[5,6,4]".toListNode()), equalTo("[7,0,8]".toListNode()))
}

class AddTwoNumbers{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2
        var head: ListNode? = null
        var tail: ListNode? = null
        var carry = 0
        while (l1 != null || l2 != null) {
            val n1 = l1?.`val` ?: 0
            val n2 = l2?.`val` ?: 0
            val sum = n1 + n2 + carry
            if (head == null) {
                tail = ListNode(sum % 10)
                head = tail
            } else {
                tail!!.next = ListNode(sum % 10)
                tail = tail.next
            }
            carry = sum / 10
            if (l1 != null) {
                l1 = l1.next
            }
            if (l2 != null) {
                l2 = l2.next
            }
        }
        if (carry > 0) {
            tail!!.next = ListNode(carry)
        }
        return head
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}