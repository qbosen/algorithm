package leetcode.editor.cn;

//633 平方数之和
/* 5 */
public class SumOfSquareNumbers {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            long left = 0;
            long right = (long) Math.sqrt(c);
            while (left <= right) {
                long sum = left * left + right * right;
                if (sum == c) {
                    return true;
                } else if (sum > c) {
                    right--;
                } else {
                    left++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}