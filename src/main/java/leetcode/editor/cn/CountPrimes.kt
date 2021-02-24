package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import java.util.*


//204 计数质数
/* 10 */

fun main() {
    val result = CountPrimes.Solution()::countPrimes
    assertThat(result(10), equalTo(4))
    assertThat(result(0), equalTo(0))
    assertThat(result(1), equalTo(0))
}

class CountPrimes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun countPrimes(n: Int): Int {
            val primes = ArrayList<Int>()
            val isPrime = IntArray(n) { 1 }
            for (i in 2 until n) {
                if (isPrime[i] == 1) {
                    primes.add(i)
                }
                var j = 0
                while (j < primes.size && i * primes[j] < n) {
                    isPrime[i * primes[j]] = 0
                    if (i % primes[j] == 0) {
                        break
                    }
                    ++j
                }
            }
            return primes.size
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}