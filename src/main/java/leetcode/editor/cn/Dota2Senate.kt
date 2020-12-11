package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import java.util.*

//649 Dota2 参议院
/* "RD" */

fun main() {
    val result = Dota2Senate.Solution()::predictPartyVictory
    assertThat(result("RD"), equalTo("Radiant"))
    assertThat(result("RDD"), equalTo("Dire"))
    assertThat(result("DDRRR"), equalTo("Dire"))
}

class Dota2Senate {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun predictPartyVictory(senate: String): String {
            val n = senate.length
            val r = LinkedList<Int>()
            val d = LinkedList<Int>()
            senate.forEachIndexed { idx, data ->
                if (data == 'R') r.add(idx)
                else d.add(idx)
            }

            while (r.isNotEmpty() && d.isNotEmpty()) {
                if (r.peek() < d.peek()) {
                    r.add(r.poll() + n)
                    d.poll()
                } else {
                    d.add(d.poll() + n)
                    r.poll()
                }
            }
            return if (r.isNotEmpty()) "Radiant" else "Dire"
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}