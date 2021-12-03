package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[1005] K 次取反后最大化的数组和
/* [4,2,3],1 */
public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new MaximizeSumOfArrayAfterKNegations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            int ans = Arrays.stream(nums).sum();
            for (int i = -100; i < 0; ++i) {
                if (freq.containsKey(i)) {
                    int ops = Math.min(k, freq.get(i));
                    ans += (-i) * ops * 2;
                    freq.put(i, freq.get(i) - ops);
                    freq.put(-i, freq.getOrDefault(-i, 0) + ops);
                    k -= ops;
                    if (k == 0) {
                        break;
                    }
                }
            }
            if (k > 0 && k % 2 == 1 && !freq.containsKey(0)) {
                for (int i = 1; i <= 100; ++i) {
                    if (freq.containsKey(i)) {
                        ans -= i * 2;
                        break;
                    }
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}