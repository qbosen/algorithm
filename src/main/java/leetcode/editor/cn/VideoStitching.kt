package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DIntArray

// 1024 视频拼接
/* [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]],10 */

fun main() {
    val result = VideoStitching.Solution()::videoStitching
    assertThat(result("[[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]".to2DIntArray(), 10), equalTo(3))
    assertThat(result("[[0,1],[1,2]]".to2DIntArray(), 5), equalTo(-1))
    assertThat(result("[[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]],".to2DIntArray(), 9), equalTo(3))
    assertThat(result("[[0,4],[2,8]],".to2DIntArray(), 5), equalTo(2))
}

class VideoStitching {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun videoStitching(clips: Array<IntArray>, T: Int): Int {
            val maxN = IntArray(T)  // t为左端点时的最远右端点
            var result = 0
            var pre = 0
            var last = 0
            for (clip in clips) {
                if (clip[0] < T) {  // 更新
                    maxN[clip[0]] = Math.max(maxN[clip[0]], clip[1])
                }
            }
            for (i in 0 until T) {
                last = Math.max(last, maxN[i])
                if (i == last) return -1
                if (i == pre) {
                    result++
                    pre = last
                }
            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}