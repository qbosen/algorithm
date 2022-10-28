package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//[907] 子数组的最小值之和
/* [3,1,2,4] */
public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayMinimums().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = 1000_000_007;
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            long res = 0;
            Deque<Integer> d = new ArrayDeque<>();
            for (int r = 0; r <= n; r++) {
                int t = r < n ? arr[r] : 0;
                while (!d.isEmpty() && arr[d.peekLast()] >= t) {
                    int cur = d.pollLast();
                    int l = d.isEmpty() ? -1 : d.peekLast();
                    int a = cur - l, b = r - cur;
                    res += (long) a * b % MOD * arr[cur] % MOD;
                    res %= MOD;
                }
                d.addLast(r);
            }
            return (int) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}