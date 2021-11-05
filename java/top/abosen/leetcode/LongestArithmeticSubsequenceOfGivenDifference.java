package top.abosen.leetcode;

import java.util.HashMap;
import java.util.Map;

//[1218] 最长定差子序列
/* [1,2,3,4],1 */
public class LongestArithmeticSubsequenceOfGivenDifference {
    public static void main(String[] args) {
        Solution solution = new LongestArithmeticSubsequenceOfGivenDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubsequence(int[] arr, int d) {
            Map<Integer, Integer> dp = new HashMap<>();
            int res = 0;
            for (int i : arr) {
                dp.put(i, dp.getOrDefault(i - d, 0) + 1);
                res = Math.max(res, dp.get(i));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}