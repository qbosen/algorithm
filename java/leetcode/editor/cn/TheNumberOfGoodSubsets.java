package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[1994] 好子集的数目
/* [1,2,3,4] */
public class TheNumberOfGoodSubsets {
    public static void main(String[] args) {
        Solution solution = new TheNumberOfGoodSubsets().new Solution();
        //System.out.println(solution.numberOfGoodSubsets(new int[]{1, 2, 3, 4}));
        System.out.println(solution.numberOfGoodSubsets(new int[]{2,17,8,1,30,26,6,2,5,10,28,15,11,15,25,24,24,13,23,27,23,24,20,1,25,1,21,23,10,21,12,14,13,26,18,21,12,14,26,8,16,11,21,8,9,5,3,25,2,14,23,23,16,8,19,5,9,26,17,15,15,17,9,18,25,14,10,30,20,21,23,19,11,21,25,8,25,1,5,17,30,4,6,2,22,18,10,18,30,12,8,6,18,23,22,4,23,27,23,27,19,11,25,20,30,16,29,1,22,26,19,2,13,8,19,23,3,27,20,18,11,2,23,3,5,16,3,23,22,7,24,25,16,13,5,17,24,14,10,19,11,29,8,16,5,14,8,26,15,7,3,11,19,12,27,24,1,6,4,16,8,7,25,12,21,20,15,25,29,6,25,5,28,10,3,27,19,12,1,13,22,5,13,5,18,6,2,10,24,7,14,7,26,10,4,17,4,24,6,5,5,1,7,5,14,18,23,10,20,7,2,28,15,30,16,8,24,11,2,4,13,10,29,11,20,8,3,17,8,4,26,26,5,16,30,7,7,22,22,14,3,29,20,17,27,2,20,23,1,7,4,16,9,15,15,23,8,11,14,18,12,3,26,27,13,17,20,27,11,5,14,12,18,19,21,20,4,27,5,17,19,5,1,18,22,16,8,29,21,3,20,17,3,15,29,4,27,2,10}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int MOD = 1000_000_000 + 7;

        public int numberOfGoodSubsets(int[] nums) {
            // int 不够加
            long[] dp = new long[1 << primes.length];
            dp[0] = 1;

            // 统计nums分布
            Map<Integer, Integer> counter = new HashMap<>();
            for (int num : nums) {
                counter.compute(num, (k, v) -> v == null ? 1 : v + 1);
            }

            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                if (num == 1) continue;
                int encode = encoding(num);
                if (encode == -1) continue;

                // 遍历所有1024个state 找出包含encode状态的state，进行累加
                // note: 从后往前
                for (int state = dp.length - 1; state >= encode; state--) {
                    if(state - encode == (state ^ encode)){
                        dp[state] = (dp[state] + (dp[state-encode] * count ) % MOD) % MOD;
                    }
                }
            }

            // 计算合法状态总数
            long res = 0;
            for (int i = 1; i < dp.length; i++) {
                res = (res + dp[i]) % MOD;
            }
            // 计算1的作用
            // note: 2^count[1] 可能过大, 需要MOD 过程
            long power = 1;
            for (int i = 0; i < counter.getOrDefault(1, 0); i++) {
                power = (power << 1) % MOD;
            }

            res = (res * power) % MOD;
            return (int) res;
        }

        private int encoding(int num) {
            // 试除法
            int encode = 0;
            for (int i = 0; i < primes.length; i++) {
                if (num % primes[i] == 0) {
                    encode += (1 << i);
                    num /= primes[i];
                }
                if (num % primes[i] == 0) {
                    // 重复质因子
                    return -1;
                }
            }
            return encode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}