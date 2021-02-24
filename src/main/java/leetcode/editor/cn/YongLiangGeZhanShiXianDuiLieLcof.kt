package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import java.util.*

// 用两个栈实现队列
// 剑指 Offer 09
/* ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"],[[],[3],[],[],[]] */

fun main() {
    val queue = YongLiangGeZhanShiXianDuiLieLcof.CQueue()
    queue.appendTail(3)
    queue.deleteHead().also { assertThat(it, equalTo(3)) }
    queue.deleteHead().also { assertThat(it, equalTo(-1)) }
}

class YongLiangGeZhanShiXianDuiLieLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        val tail : Queue<Int> = LinkedList()
        val head : Queue<Int> = LinkedList()
        fun appendTail(value: Int) {
            tail.offer(value)
        }

        fun deleteHead(): Int {
            if(head.isNotEmpty()) return head.poll()
            if(tail.isEmpty()) return -1
            while(tail.isNotEmpty()){
                head.offer(tail.poll())
            }
            return head.poll()
        }

    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * var obj = CQueue()
     * obj.appendTail(value)
     * var param_2 = obj.deleteHead()
     */
//leetcode submit region end(Prohibit modification and deletion)

}