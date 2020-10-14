package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import util.listMatcher
import java.util.*

// 1002 查找常用字符
/* ["bella","label","roller"] */

fun main() {
    val result = FindCommonCharacters.Solution()::commonChars
    assertThat(result(arrayOf("bella", "label", "roller")), listMatcher(listOf("e", "l", "l")))
    assertThat(result(arrayOf("cool", "lock", "cook")), listMatcher(listOf("c", "o")))
}

class FindCommonCharacters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // leetcode kotlin当前版本低于1.4
        private inline fun <R> IntArray.flatMapIndexed(transform: (index: Int, Int) -> Iterable<R>): List<R> {
            return flatMapIndexedTo(ArrayList<R>(), transform)
        }
        private inline fun <R, C : MutableCollection<in R>> IntArray.flatMapIndexedTo(destination: C, transform: (index: Int, Int) -> Iterable<R>): C {
            for ((index, element) in this.withIndex()) {
                destination.addAll(transform(index, element))
            }
            return destination
        }
        fun commonChars(A: Array<String>): List<String> {
            if (A.isEmpty()) return emptyList()
            val frequency = IntArray(26)
            val minFreq = IntArray(26) { Int.MAX_VALUE }
            fun update(input: String) {
                Arrays.fill(frequency, 0)
                input.forEach { frequency[it - 'a']++ }
                minFreq.forEachIndexed { index, i -> minFreq[index] = Math.min(i, frequency[index]) }
            }
            A.forEach(::update)
            return minFreq.flatMapIndexed { index, i -> Collections.nCopies(i, ('a' + index).toString()) }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}