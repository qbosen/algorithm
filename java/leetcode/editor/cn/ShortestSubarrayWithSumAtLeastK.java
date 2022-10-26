package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//[862] 和至少为 K 的最短子数组
/* [1],1 */
public class ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        Solution solution = new ShortestSubarrayWithSumAtLeastK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] sum = new long[n + 1];

            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }

            Deque<Integer> deque = new ArrayDeque<>();
            int res = n + 1;
            for (int i = 0; i <= n; i++) {
                long curSum = sum[i];
                while (!deque.isEmpty() && curSum - sum[deque.peekFirst()] >= k) {
                    res = Math.min(res, i - deque.pollFirst());
                }

                while (!deque.isEmpty() && sum[deque.peekLast()] >= curSum) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            return res <= n ? res : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}