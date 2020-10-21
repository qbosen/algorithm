package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 925 长按键入
/* "alex","aaleex" */

fun main() {
    val result = LongPressedName.Solution()::isLongPressedName
    assertThat(result("alex", "aaleex"), equalTo(true))
    assertThat(result("alex", "aaleelx"), equalTo(false))
    assertThat(result("saeed", "ssaaedd"), equalTo(false))
    assertThat(result("leelee", "lleeelee"), equalTo(true))
    assertThat(result("laiden", "laiden"), equalTo(true))
    assertThat(result("alex", "alexxr"), equalTo(false))
    assertThat(result("vtkgn", "vttkgnn"), equalTo(true))
    assertThat(result("zlexya", "aazlllllllllllllleexxxxxxxxxxxxxxxya"), equalTo(false))
}

class LongPressedName {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isLongPressedName(name: String, typed: String): Boolean {
            var i = 0
            var j = 0
            while (j < typed.length) {
                if (i < name.length && name[i] == typed[j]) {
                    i++
                    j++
                } else if (j > 0 && typed[j] == typed[j - 1]) {
                    j++
                } else {
                    return false
                }
            }
            return i == name.length
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}