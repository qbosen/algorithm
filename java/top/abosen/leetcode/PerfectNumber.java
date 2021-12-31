package top.abosen.leetcode;

//[507] 完美数
/* 28 */
public class PerfectNumber {
    public static void main(String[] args) {
        Solution solution = new PerfectNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPerfectNumber(int num) {
            if (num == 1) {
                return false;
            }
            int sum = 1;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    sum += i;
                    if (i * i != num) {
                        // 不相等的另一个质因数
                        sum += num / i;
                    }
                }
            }
            return sum == num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}