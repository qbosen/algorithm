package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//368 最大整除子集
/* [1,2,3] */
public class LargestDivisibleSubset {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            // dp[i] = nums[i]为区间最大时的 整除集大小
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int maxSize = 1;
            int maxValue = dp[0];

            for (int i = 1; i < n; i++) {
                // 对于 nums[i] 最大时，统计前面的约数
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                if (dp[i] > maxSize) {
                    maxSize = dp[i];
                    maxValue = nums[i];
                }
            }

            // 反推
            List<Integer> res = new ArrayList<>();
            if (maxSize == 1) {
                res.add(nums[0]);
                return res;
            }

            for (int i = n - 1; i >= 0 && maxSize > 0; i--) {
                if (dp[i] == maxSize && maxValue % nums[i] == 0) {
                    res.add(nums[i]);
                    maxValue = nums[i];
                    maxSize--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}