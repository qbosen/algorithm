package leetcode.editor.cn;
// 盛最多水的容器
// 11
// [1,8,6,2,5,4,8,3,7]

import util.IntUtil;

public class ContainerWithMostWater {
    public static void run(Solution solution, int expect, String height) {
        int[] height_ = IntUtil.parse1DIntArray(height);
        int result = solution.maxArea(height_);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        run(solution, 49, "[1,8,6,2,5,4,8,3,7]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int l = 0;
            int r = height.length - 1;

            int area = 0;
            while (l < r) {
                area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
                if (height[l] < height[r]) {
                    // 左低右高 移动左
                    int lastL = l;
                    while (l < r && height[l] <= height[lastL]) {
                        l++;
                    }
                }else {
                    int lastR = r;
                    while (l < r && height[r] <= height[lastR]) {
                        r--;
                    }
                }
            }
            return area;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}