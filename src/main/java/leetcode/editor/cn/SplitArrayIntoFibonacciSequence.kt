package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.listMatcher
import util.to1DIntArray

//842 将数组拆分成斐波那契序列
/* "123456579" */

fun main() {
    val result = SplitArrayIntoFibonacciSequence.Solution()::splitIntoFibonacci
    assertThat(result("123456579"), equalTo("[123,456,579]".to1DIntArray().toList()))
    assertThat(result("11235813"), equalTo("[1,1,2,3,5,8,13]".to1DIntArray().toList()))
    assertThat(result("112358130"), equalTo("[]".to1DIntArray().toList()))
    assertThat(result("0123"), equalTo("[]".to1DIntArray().toList()))
    assertThat(result("1101111"), oneOf("[110, 1, 111]".to1DIntArray().toList(), "[11,0,11,11]".to1DIntArray().toList()))
}

class SplitArrayIntoFibonacciSequence {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun splitIntoFibonacci(S: String): List<Int> {
            val res = ArrayList<Int>()

            fun backtrack(idx: Int, sum: Int, prev: Int): Boolean {
                if (idx == S.length) return res.size >= 3
                var current = 0L
                for (i in idx until S.length) {
                    if (i > idx && S[idx] == '0') break
                    current = current * 10 + (S[i] - '0')
                    if (current > Int.MAX_VALUE) break
                    val curInt = current.toInt()
                    if (res.size >= 2) {
                        if (curInt > sum) break
                        if (curInt < sum) continue
                    }
                    res.add(curInt)
                    if (backtrack(i + 1, prev + curInt, curInt)) {
                        return true
                    } else {
                        res.removeAt(res.lastIndex)
                    }
                }
                return false
            }

            backtrack(0, 0, 0)
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}