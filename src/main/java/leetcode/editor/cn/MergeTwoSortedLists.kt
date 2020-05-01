package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import struct.ListNode
import util.toListNode

// 合并两个有序链表
// 21
/* [1,2,4],[1,3,4] */

fun main() {
    val result = MergeTwoSortedLists.Solution()::mergeTwoLists
    assertThat(result("[1,2,4]".toListNode(), "[1,3,4]".toListNode()), equalTo("[1,1,2,3,4,4]".toListNode()))
}

class MergeTwoSortedLists {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            val dummy = ListNode(-1)
            var node = dummy
            var l1 = l1
            var l2 = l2
            while (l1 != null && l2 != null) {
                if (l1.`val` > l2.`val`) {
                    node.next = l2.also { node = it }
                    l2 = l2.next
                } else {
                    node.next = l1.also { node = it }
                    l1 = l1.next
                }
            }

            while (l1 != null) {
                node.next = l1.also { node = it }
                l1 = l1.next
            }
            while (l2 != null) {
                node.next = l2.also { node = it }
                l2 = l2.next
            }
            return dummy.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}