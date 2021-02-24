package leetcode.editor.cn

import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import java.util.*


// 最小栈
// 155
/* ["MinStack","push","push","push","getMin","pop","top","getMin"],[[],[-2],[0],[-3],[],[],[],[]] */

fun main() {
    val stack = MinStack.MinStack()
    stack.push(-2)
    stack.push(0)
    stack.push(-3)
    assertThat(stack.getMin(), equalTo(-3))
    stack.pop()
    assertThat(stack.top(), equalTo(0))
    assertThat(stack.getMin(), equalTo(-2))
}

class MinStack {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack() {
        val stack = LinkedList<Int>()
        val minStack = LinkedList<Int>()

        fun push(x: Int) {
            val min = if (minStack.isEmpty()) x else Math.min(x, minStack.peek())
            stack.push(x)
            minStack.push(min)
        }

        fun pop() {
            stack.pop()
            minStack.pop()
        }

        fun top(): Int {
            return stack.peek()
        }

        fun getMin(): Int {
            return minStack.peek()
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}