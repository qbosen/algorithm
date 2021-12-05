package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[372] 超级次方
/* 2,[3] */
public class SuperPow {
    public static void main(String[] args) {
        Solution solution = new SuperPow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = 1337;

        public int superPow(int a, int[] b) {
            int ans = 1;
            for (int i : b) {
                ans = (qpow(ans, 10) * qpow(a, i)) % MOD;
            }
            return ans;
        }


        int qpow(int a, int b) {
            int ans = 1;
            a %= MOD;
            while (b != 0) {
                if ((b & 1) != 0) {
                    ans = ans * a % MOD;
                }
                a = a * a % MOD;
                b >>= 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}