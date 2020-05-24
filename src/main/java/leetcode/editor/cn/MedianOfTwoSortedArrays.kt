package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 寻找两个正序数组的中位数
// 4
/* [1,3],[2] */

fun main() {
    val result = MedianOfTwoSortedArrays.Solution()::findMedianSortedArrays
    assertThat(result("[1,3]".to1DIntArray(), "[2]".to1DIntArray()), equalTo(2.0))
    assertThat(result("[1,2]".to1DIntArray(), "[3,4]".to1DIntArray()), equalTo(2.5))
}

class MedianOfTwoSortedArrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            val arr1 = if (nums1.size > nums2.size) nums2 else nums1
            val arr2 = if (nums1.size > nums2.size) nums1 else nums2

            val totalLeft = (nums1.size + nums2.size + 1) / 2
            // 分割线右边的元素下标
            // arr1[i-1] <= arr2[j] && arr2[j-1]<=arr1[i]
            var left = 0
            var right = arr1.size

            while (left < right) {
                val i = left + (right - left + 1) / 2
                val j = totalLeft - i
                if (arr1[i - 1] > arr2[j]) {    // 左移
                    right = i - 1
                } else {
                    left = i
                }
            }
            val i = left
            val j = totalLeft - i
            val arr1LeftMax = if (i == 0) Int.MIN_VALUE else arr1[i - 1]
            val arr1RightMin = if (i == arr1.size) Int.MAX_VALUE else arr1[i]
            val arr2LeftMax = if (j == 0) Int.MIN_VALUE else arr2[j - 1]
            val arr2RightMin = if (j == arr2.size) Int.MAX_VALUE else arr2[j]

            if ((arr1.size + arr2.size) % 2 == 1) {
                return Math.max(arr1LeftMax, arr2LeftMax).toDouble()
            } else {
                return (Math.max(arr1LeftMax, arr2LeftMax) + Math.min(arr1RightMin, arr2RightMin)).toDouble() / 2
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}