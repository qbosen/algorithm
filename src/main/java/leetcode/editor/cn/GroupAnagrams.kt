package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.list2DMatcher
import util.to2DStringList
import util.toStringList

//49 字母异位词分组
/* ["eat","tea","tan","ate","nat","bat"] */

fun main() {
    val result = GroupAnagrams.Solution()::groupAnagrams
    assertThat(result("""["eat","tea","tan","ate","nat","bat"]""".toStringList().toTypedArray()),
            list2DMatcher("""[["ate","eat","tea"],["nat","tan"],["bat"]]""".to2DStringList()))

    assertThat(result("""["ddddddddddg","dgggggggggg"]""".toStringList().toTypedArray()),
            list2DMatcher("""[["dgggggggggg"],["ddddddddddg"]]""".to2DStringList()))
}

class GroupAnagrams {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            fun category(str: String): Map<Char, Int> = HashMap<Char, Int>().also { map ->
                str.forEach { map.compute(it) { _, v -> (v ?: 0) + 1 } }
            }

            return strs.groupBy(::category).values.toList()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}