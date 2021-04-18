package leetcode.editor.cn;

// 154 寻找旋转排序数组中的最小值 II
/* [1,3,5] */

public class FindMinimumInRotatedSortedArrayIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] < nums[r]) {
                    r = mid;
                } else if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else {
                    r--;
                }
            }
            return nums[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}