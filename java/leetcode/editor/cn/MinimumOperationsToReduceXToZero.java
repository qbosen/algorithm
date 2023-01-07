package leetcode.editor.cn;

import java.util.Arrays;

//[1658] 将 x 减到 0 的最小操作数
/* [1,1,4,2,3],5 */
public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceXToZero().new Solution();
        System.out.println(solution.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(solution.minOperations(new int[]{5, 6, 7, 8}, 4));
        System.out.println(solution.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();

            if (sum < x) {
                return -1;
            }

            int right = 0;
            int lsum = 0, rsum = sum;
            int ans = n + 1;

            for (int left = -1; left < n; ++left) {
                if (left != -1) {
                    lsum += nums[left];
                }
                while (right < n && lsum + rsum > x) {
                    rsum -= nums[right];
                    ++right;
                }
                if (lsum + rsum == x) {
                    ans = Math.min(ans, (left + 1) + (n - right));
                }
            }

            return ans > n ? -1 : ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}