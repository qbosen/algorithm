package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import util.list2DMatcher
import util.to1DIntArray
import util.to2DIntList
import java.util.*


// 四数之和
// 18
/* [1,0,-1,0,-2,2],0 */

fun main() {
    val result = FourSum.Solution()::fourSum
    assertThat(result("[1,0,-1,0,-2,2]".to1DIntArray(),0), list2DMatcher( "[[-1,0,0,1],[-2,-1,1,2],[-2,0,0,2]]".to2DIntList()))
}

class FourSum{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val quadruplets: MutableList<List<Int>> = ArrayList()
        if (nums.size < 4) {
            return quadruplets
        }
        Arrays.sort(nums)
        val length = nums.size
        for (i in 0 until length - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue
            }
            for (j in i + 1 until length - 2) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue
                }
                var left = j + 1
                var right = length - 1
                while (left < right) {
                    val sum = nums[i] + nums[j] + nums[left] + nums[right]
                    if (sum == target) {
                        quadruplets.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++
                        }
                        left++
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--
                        }
                        right--
                    } else if (sum < target) {
                        left++
                    } else {
                        right--
                    }
                }
            }
        }
        return quadruplets
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}