package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 把数字翻译成字符串
// 面试题46

fun main() {
    val result = BaShuZiFanYiChengZiFuChuanLcof.Solution()::translateNum
    assertThat(result(12258), equalTo(5))
}

class BaShuZiFanYiChengZiFuChuanLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun translateNum(num: Int): Int {
            val src = num.toString()
            var p = 0
            var q = 0
            var r = 1
            for (i in src.indices) {
                p = q
                q = r
                r = 0
                r += q
                if (i == 0) continue
                val pre = src.substring(i - 1, i + 1)
                if (pre >= "10" && pre <= "25") {
                    r += p
                }
            }
            return r
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}