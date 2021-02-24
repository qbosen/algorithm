package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
// 数字范围按位与
// 201
/* 5,7 */

fun main() {
    val result = BitwiseAndOfNumbersRange.Solution()::rangeBitwiseAnd
    assertThat(result(5,7), equalTo( 4))
}

class BitwiseAndOfNumbersRange{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var r = n
        while(r > m){
            r = r and r-1
        }
        return r
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}