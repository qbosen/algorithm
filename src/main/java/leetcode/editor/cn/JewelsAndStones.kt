package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
// 宝石与石头
// 771
/* "aA","aAAbbbb" */

fun main() {
    val result = JewelsAndStones.Solution()::numJewelsInStones
    assertThat(result("aA","aAAbbbb"), equalTo( 3))
}

class JewelsAndStones{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numJewelsInStones(J: String, S: String): Int {
        val set = J.toCharArray().toSet()
        return S.toCharArray().count { set.contains(it) }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}