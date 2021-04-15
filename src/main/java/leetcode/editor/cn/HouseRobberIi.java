package leetcode.editor.cn;

//213 打家劫舍 II
/* [2,3,2] */
public class HouseRobberIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return nums[0];
            }
            if (n == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(
                    nums[0] + doRob(nums, 2, n - 1),
                    doRob(nums, 1, n)
            );

        }

        private int doRob(int[] nums, int start, int stop) {
            if (start >= stop) return 0;
            int skip = 0;
            int rob = nums[start];
            for (int i = start + 1; i < stop; i++) {
                int prevSkip = skip;
                skip = Math.max(rob, skip);
                rob = prevSkip + nums[i];
            }
            return Math.max(skip, rob);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}