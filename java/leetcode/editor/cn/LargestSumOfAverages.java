package leetcode.editor.cn;

//[813] 最大平均值和的分组
/* [9,1,2,3,9],3 */
public class LargestSumOfAverages {
    public static void main(String[] args) {
        Solution solution = new LargestSumOfAverages().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestSumOfAverages(int[] nums, int k) {
            int n = nums.length;
            double[] preSum = new double[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }

            double[][] dp = new double[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][1] = preSum[i] / i;
            }

            for (int j = 2; j <= k; j++) {
                for (int i = j; i <= n; i++) {
                    for (int l = j - 1; l < i; l++) {
                        dp[i][j] = Math.max(dp[i][j], dp[l][j - 1] + (preSum[i] - preSum[l]) / (i - l));
                    }
                }
            }
            return dp[n][k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}