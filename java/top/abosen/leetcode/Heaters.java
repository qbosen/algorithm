package top.abosen.leetcode;

import java.util.Arrays;

//[475] 供暖器
/* [1,2,3],[2] */
public class Heaters {
    public static void main(String[] args) {
        Solution solution = new Heaters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(heaters);
            int ans = 0;
            for (int house : houses) {
                int i = binarySearch(heaters, house);
                int j = i + 1;
                int left = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
                int right = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
                int distance = Math.min(left, right);
                ans = Math.max(ans, distance);
            }
            return ans;
        }

        public int binarySearch(int[] nums, int target) {
            if (nums[0] > target) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (right - left + 1) / 2 + left;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}