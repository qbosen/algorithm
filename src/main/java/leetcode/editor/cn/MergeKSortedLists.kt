package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.ListNode
import util.toListNode
import util.toListNodeArray
import java.util.*

// 合并K个排序链表
// 23
/* [[1,4,5],[1,3,4],[2,6]] */

fun main() {
    val result = MergeKSortedLists.Solution()::mergeKLists
    assertThat(result("[[1,4,5],[1,3,4],[2,6]]".toListNodeArray()), equalTo("[1,1,2,3,4,4,5,6]".toListNode()))
}

class MergeKSortedLists {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isEmpty()) return null
            val queue = PriorityQueue<ListNode>(lists.size) { o1, o2 ->
                o1.`val` - o2.`val`
            }
            val dummy = ListNode(-1)
            lists.forEach { it?.let { queue.add(it) } }

            var prev: ListNode = dummy
            while (!queue.isEmpty()) {
                with(queue.poll()) {
                    prev.next = ListNode(this.`val`).also { prev = it }
                    this.next?.let { queue.add(it) }
                }
            }
            return dummy.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}