package top.abosen.leetcode;

//673 最长递增子序列的个数
public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length, maxLen = 0, ans = 0;
            int[] dp = new int[n];
            int[] cnt = new int[n];
            for (int i = 0; i < n; ++i) {
                dp[i] = 1;
                cnt[i] = 1;
                for (int j = 0; j < i; ++j) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            cnt[i] = cnt[j]; // 重置计数
                        } else if (dp[j] + 1 == dp[i]) {
                            cnt[i] += cnt[j];
                        }
                    }
                }
                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                    ans = cnt[i]; // 重置计数
                } else if (dp[i] == maxLen) {
                    ans += cnt[i];
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}