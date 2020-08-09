package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 复原IP地址
// 93
/* "25525511135" */

fun main() {
    val result = RestoreIpAddresses.Solution()::restoreIpAddresses
    assertThat(result("25525511135"), equalTo(listOf("255.255.11.135", "255.255.111.35")))
}

class RestoreIpAddresses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun restoreIpAddresses(s: String): List<String> {
            val result = ArrayList<String>()
            val segCount = 4
            val segments = IntArray(4)
            fun dfs(s: String, segId: Int, segStart: Int) {
                if (segStart == s.length || segId == segCount) {
                    if (segStart == s.length && segId == segCount) {
                        result.add(segments.joinToString("."))
                    }
                    return
                }

                // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
                if (s[segStart] == '0') {
                    segments[segId] = 0
                    dfs(s, segId + 1, segStart + 1)
                }

                // 一般情况，枚举每一种可能性并递归
                var addr = 0
                for (i in segStart until s.length) {
                    addr = addr * 10 + (s[i] - '0')
                    if (addr in 1..0xFF) {
                        segments[segId] = addr
                        dfs(s, segId + 1, i + 1)
                    } else {
                        break
                    }
                }
            }

            dfs(s, 0, 0)
            return result
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}