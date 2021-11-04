package top.abosen.leetcode;

//[367] 有效的完全平方数
/* 16 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(2147483647));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            int l = 1, r = num;
            while (l <= r) {
                int m = l + (r - l) / 2;
                long square = (long) m * m;
                if (square < num) {
                    l = m + 1;
                } else if (square > num) {
                    r = m - 1;
                } else {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}