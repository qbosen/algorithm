package top.abosen.leetcode;

//[747] 至少是其他数字两倍的最大数
/* [3,6,1,0] */
public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        Solution solution = new LargestNumberAtLeastTwiceOfOthers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int dominantIndex(int[] nums) {
            if (nums.length == 1) return 0;
            int res = nums[0] > nums[1] ? 0 : 1;
            int a = nums[res], b = nums[1 - res];
            for (int i = 2; i < nums.length; i++) {
                int v = nums[i];
                if (v > a) {
                    b = a;
                    a = v;
                    res = i;
                } else if (v > b) {
                    b = v;
                }
            }
            return a >= 2 * b ? res : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}