// @algorithm @lc id=100329 lang=java 
// @title zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                int count = 1;
                int i = mid + 1;
                while (i < nums.length && nums[i] == target) {
                    count++;
                    i++;
                }
                i = mid - 1;
                while (i >= 0 && nums[i] == target) {
                    count++;
                    i--;
                }
                return count;
            }
        }
        return 0;
    }
}