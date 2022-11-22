package leetcode.editor.cn;

//[878] 第 N 个神奇数字
/* 1,2,3 */
public class NthMagicalNumber {
    public static void main(String[] args) {
        Solution solution = new NthMagicalNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthMagicalNumber(int n, int a, int b) {
            long l = Math.min(a, b);
            long r = (long) n * l;
            int c = lcm(a, b);
            while (l < r) {
                long mid = (l + r) / 2;
                long cnt = mid / a + mid / b - mid / c;
                if (cnt >= n) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int MOD = (int) (10e9 + 7);
            return (int) (r % MOD);
        }

        int lcm(int a, int b) {
            return a * b / gcd(a, b);
        }

        int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}