package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// LRU缓存机制
// 146
/* ["LRUCache","put","put","get","put","get","put","get","get","get"],[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]] */

fun main() {
    with(LruCache.LRUCache(2)) {
        put(1, 1)
        put(2, 2)
        get(1).also { assertThat(it, equalTo(1)) }
        put(3, 3)
        get(2).also { assertThat(it, equalTo(-1)) }
        put(4, 4)
        get(1).also { assertThat(it, equalTo(-1)) }
        get(3).also { assertThat(it, equalTo(3)) }
        get(4).also { assertThat(it, equalTo(4)) }
    }

    with(LruCache.LRUCache(2)) {
        put(2, 1)
        put(1, 1)
        put(2, 3)
        put(4, 1)
        get(1).also { assertThat(it, equalTo(-1)) }
        get(2).also { assertThat(it, equalTo(3)) }
    }


}

class LruCache {
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache(capacity: Int) {
        private val cache = HashMap<Int, Node>(capacity)
        private val list = ListNode()
        private val capacity = capacity
        private var size = 0

        fun get(key: Int): Int {
            val node = cache[key]
            return if (node == null) -1 else touch(node)
        }

        fun put(key: Int, value: Int) {
            val old = cache.remove(key)
            val node = Node(key, value)
            when {
                old != null -> list.removeNode(old)         // 替换旧值
                size < capacity -> size++                   // 新的值
                else -> list.removeLast()?.let { cache.remove(it.key) }       // 替换最后一个
            }

            cache[key] = node
            list.addNode(node)
        }

        private fun touch(node: Node): Int {
            list.removeNode(node)
            list.addNode(node)
            return node.value
        }

        private class Node(val key: Int, val value: Int) {
            var prev: Node? = null
            var next: Node? = null
        }

        private class ListNode {
            val head = Node(-1, -1)
            val tail = Node(-1, -1)

            init {
                head.next = tail
                tail.prev = head
            }

            fun removeNode(node: Node) {
                node.prev?.next = node.next
                node.next?.prev = node.prev
            }

            fun addNode(node: Node) {
                node.next = head.next
                head.next?.prev = node
                head.next = node
                node.prev = head
            }

            fun removeLast(): Node? {
                val last = tail.prev
                if (last == null || last === head) return null
                removeNode(last)
                return last
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}