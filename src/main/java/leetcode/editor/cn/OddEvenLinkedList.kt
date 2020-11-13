package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.ListNode
import util.toListNode

//328 奇偶链表
/* [1,2,3,4,5] */

fun main() {
    val result = OddEvenLinkedList.Solution()::oddEvenList
    assertThat(result("[1,2,3,4,5]".toListNode()), equalTo("[1,3,5,2,4]".toListNode()))
    assertThat(result("[2,1,3,5,6,4,7]".toListNode()), equalTo("[2,3,6,7,1,5,4]".toListNode()))
}

class OddEvenLinkedList {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun oddEvenList(head: ListNode?): ListNode? {
            head ?: return null
            val evenHead = head.next
            var odd = head!!
            var even = evenHead
            while(even?.next!=null ){
                odd.next = even.next
                odd = odd.next!!
                even.next = odd.next
                even = even.next
            }
            odd.next = evenHead
            return head
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}