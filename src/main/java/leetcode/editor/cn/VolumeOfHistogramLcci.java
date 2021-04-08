package leetcode.editor.cn;
//面试题 17.21 直方图的水量
/* [0,1,0,2,1,0,1,3,2,1,2,1] */
public class VolumeOfHistogramLcci{

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