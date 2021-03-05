package leetcode.editor.cn;

//300 最长递增子序列
/* [10,9,2,5,3,7,101,18] */
public class LongestIncreasingSubsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int len = 1;
            int n = nums.length;
            if (n == 0) return 0;
            int[] d = new int[n + 1];
            d[len] = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i] > d[len]) {
                    d[len + 1] = nums[i];
                    len++;
                } else {
                    int l = 1, r = len;
                    while (l < r) {
                        int mid = (l + r) / 2;
                        if (d[mid] < nums[i]) {
                            l = mid + 1;
                        } else {
                            r = mid;
                        }
                    }
                    d[l] = nums[i];
                }
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}