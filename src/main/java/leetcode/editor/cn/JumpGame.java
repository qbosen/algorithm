package leetcode.editor.cn;
// 跳跃游戏
// 55
// [2,3,1,1,4]

import util.IntUtil;

public class JumpGame {
    public static void run(Solution solution, boolean expect, String nums) {
        int[] nums_ = IntUtil.parse1DIntArray(nums);
        boolean result = solution.canJump(nums_);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        run(solution, true, "[2,3,1,1,4]");
        run(solution, false, "[3,2,1,0,4]");
        run(solution, true, "[1,2,3]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) return true;
            int maxFar = nums[0];
            for (int i = 1; i <= maxFar && i < nums.length; i++) {
                maxFar = Math.max(maxFar, i + nums[i]);
            }
            return maxFar >= nums.length - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}