package leetcode.editor.cn;

//[2180] 统计各位数字之和为偶数的整数个数
/* 4 */
public class CountIntegersWithEvenDigitSum {
    public static void main(String[] args) {
        Solution solution = new CountIntegersWithEvenDigitSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countEven(int num) {
            int res = 0;
            for (int i = 2; i <= num; i++) {
                int s = 0, n = i;
                while (n != 0) {
                    s += n % 10;
                    n /= 10;
                }
                if (s % 2 == 0) res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}