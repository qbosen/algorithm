package leetcode.editor.cn;

//81 搜索旋转排序数组 II
/* [2,5,6,0,0,1,2],0 */
public class SearchInRotatedSortedArrayIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (nums[mid] == target) {
                    return true;
                }
                if (nums[l] == nums[mid] && nums[r] == nums[mid]) {
                    l++;
                    r--;
                } else if (nums[l] <= nums[mid]) {
                    if (nums[l] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[nums.length - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}