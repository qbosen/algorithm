package leetcode.editor.cn;

import java.util.Arrays;

//[1175] 质数排列
/* 5 */
public class PrimeArrangements {
    public static void main(String[] args) {
        Solution solution = new PrimeArrangements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        static long mod = 1000_000_007;

        public int numPrimeArrangements(int n) {
            int idx = Arrays.binarySearch(primes, n);
            int primeCount;
            if (idx < 0) {
                primeCount = -idx - 1;
            } else {
                primeCount = idx + 1;
            }
            long result = 1;
            int i = primeCount;
            while (i > 1) {
                result = (result * i) % mod;
                i--;
            }
            i = n - primeCount ;
            while (i > 1) {
                result = (result * i) % mod;
                i--;
            }
            return (int) result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}