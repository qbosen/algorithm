// @algorithm @lc id=100304 lang=java 
// @title lian-xu-zi-shu-zu-de-zui-da-he-lcof


public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}