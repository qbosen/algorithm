package leetcode.editor.cn;
// 接雨水
// 42
// [0,1,0,2,1,0,1,3,2,1,2,1]

import util.IntUtil;

public class TrappingRainWater {
    public static void run(Solution solution, int expect, String height) {
        int[] height_ = IntUtil.parse1DIntArray(height);
        int result = solution.trap(height_);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        run(solution, 6, "[0,1,0,2,1,0,1,3,2,1,2,1]");
        run(solution, 1, "[4,2,3]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            if (height.length <= 2) return 0;
            int[] memo = new int[height.length];
            int lMax = height[0];
            for (int i = 0; i < height.length; i++) {
                if (lMax < height[i]) {
                    lMax = height[i];
                }
                memo[i] = lMax;
            }
            int rMax = height[height.length - 1];
            int result = 0;
            for (int i = height.length - 1; i >= 0; i--) {
                if (rMax < height[i]) {
                    rMax = height[i];
                }
                memo[i] = Math.min(memo[i], rMax);
                result += memo[i] - height[i];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}