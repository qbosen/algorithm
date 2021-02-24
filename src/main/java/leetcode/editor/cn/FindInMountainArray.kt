package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 山脉数组中查找目标值
// 1095
/* [1,2,3,4,5,3,1],3 */

fun main() {
    val result = FindInMountainArray.Solution()::findInMountainArray
    assertThat(result(3, FindInMountainArray.MountainArray("[1, 2, 3, 4, 5, 3, 1]")), equalTo(2))
    assertThat(result(3, FindInMountainArray.MountainArray("[0,1,2,4,2,1]")), equalTo(-1))
    assertThat(result(0, FindInMountainArray.MountainArray("[3,5,3,2,0]")), equalTo(4))
    assertThat(result(3, FindInMountainArray.MountainArray("[3,5,3,2,0]")), equalTo(0))
    assertThat(result(5, FindInMountainArray.MountainArray("[1,5,2]")), equalTo(1))
    assertThat(result(3, FindInMountainArray.MountainArray("[1,5,2]")), equalTo(-1))
    assertThat(result(2, FindInMountainArray.MountainArray("[1,5,2]")), equalTo(2))
}


class FindInMountainArray {

    // This is MountainArray's API interface.
    // You should not implement it, or speculate about its implementation
    class MountainArray(input: String) {
        val data: IntArray = input.to1DIntArray()

        fun get(index: Int): Int = data[index]

        fun length(): Int = data.size
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
            // 找高点
            val length = mountainArr.length()
            var li = 0
            var ri = length - 1
            var top = -1

            if (target < mountainArr.get(li) && target < mountainArr.get(ri)) return -1
            while (li <= ri && top == -1) {
                val m = li + (ri - li) / 2
                val mv = mountainArr.get(m)
                val mlv = if (m - 1 >= 0) mountainArr.get(m - 1) else -1
                val mrv = if (m + 1 < length) mountainArr.get(m + 1) else -1

                when {
                    mv > mlv && mv > mrv -> top = m
                    mv < mrv -> li = m + 1
                    mv < mlv -> ri = m - 1
                }
            }

            // 左区间
            li = 0
            ri = top
            while (li <= ri) {
                val m = li + (ri - li) / 2
                val mv = mountainArr.get(m)
                when {
                    target == mv -> return m
                    target < mv -> ri = m - 1
                    target > mv -> li = m + 1
                }
            }

            // 右区间
            li = top + 1
            ri = length - 1
            while (li <= ri) {
                val m = li + (ri - li) / 2
                val mv = mountainArr.get(m)
                when {
                    target == mv -> return m
                    target > mv -> ri = m - 1
                    target < mv -> li = m + 1
                }
            }
            return -1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}