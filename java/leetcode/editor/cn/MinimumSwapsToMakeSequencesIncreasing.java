package leetcode.editor.cn;

//
/* [1,3,5,4],[1,2,3,7] */
public class MinimumSwapsToMakeSequencesIncreasing {
    public static void main(String[] args) {
        Solution solution = new MinimumSwapsToMakeSequencesIncreasing().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwap(int[] nums1, int[] nums2) {
            // dp[i][0/1] 是使前i位置严格递增且第i个位置(未)发生交换的 所需要的最小次数
            //  Math.min{ dp[n-1][0], dp[n-1][1]}

            int n = nums1.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = 1;

            for (int i = 1; i < n; i++) {
                boolean c1 = nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1];
                boolean c2 = nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1];
                if (c1 && c2) {
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i - 1][1] + 1, dp[i - 1][0] + 1);
                } else if (c1) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                } else {
                    dp[i][0] = dp[i - 1][1];
                    dp[i][1] = dp[i - 1][0] + 1;
                }
            }

            return Math.min(dp[n - 1][0], dp[n - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}