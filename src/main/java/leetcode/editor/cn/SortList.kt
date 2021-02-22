package leetcode.editor.cn

import struct.ListNode

//148 排序链表
/* [4,2,1,3] */

class SortList {
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun sortList(head: ListNode?): ListNode? {
            if (head == null) return head

            var length = 0
            var node = head
            while (node != null) {
                node = node.next
                length++
            }

            val dummyHead = ListNode(-1)
            dummyHead.next = head

            var subLength = 1
            while (subLength < length) {
                var prev = dummyHead
                var current = dummyHead.next
                while (current != null) {
                    val a = current
                    var i = 1
                    while (i < subLength && current?.next != null) {
                        current = current.next
                        i++
                    }
                    val b = current?.next
                    current?.next = null // a截断
                    i = 1

                    current = b
                    while (i < subLength && current?.next != null) {
                        current = current.next
                        i++
                    }
                    val next = current?.next
                    current?.next = null //b截断

                    val merge = mergeSort(a, b)
                    prev.next = merge   // 和上一次连起来

                    while (prev.next != null) { //找到本次的最后一个
                        prev = prev.next!!
                    }
                    current = next
                }
                subLength *= 2
            }
            return dummyHead.next
        }

        fun mergeSort(a: ListNode?, b: ListNode?): ListNode? {
            val head = ListNode(-1)
            var current = head
            var curA = a
            var curB = b
            while (curA != null && curB != null) {
                if (curA.`val` <= curB.`val`) {
                    current.next = curA
                    curA = curA.next
                } else {
                    current.next = curB
                    curB = curB.next
                }
                current = current.next!!
            }

            if (curA != null) {
                current.next = curA
            }
            if (curB != null) {
                current.next = curB
            }
            return head.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}