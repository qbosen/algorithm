package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[1984] 学生分数的最小差值
/* [90],1 */
public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public static void main(String[] args) {
        Solution solution = new MinimumDifferenceBetweenHighestAndLowestOfKScores().new Solution();
        System.out.println(solution.minimumDifference(new int[]{87063, 61094, 44530, 21297, 95857, 93551, 9918}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDifference(int[] nums, int k) {
            if (k == 1 || nums.length <= 1) {
                return 0;
            }
            Arrays.sort(nums);
            int res = nums[k - 1] - nums[0];
            for (int i = 0; i + k - 1 < nums.length; i++) {
                int d = nums[i + k - 1] - nums[i];
                res = Math.min(res, d);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}