package top.abosen.leetcode;

import java.util.Arrays;

//[66] 加一
/* [1,2,3] */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 4})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 9, 9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{0})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            boolean carry = false;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                    carry = true;
                } else {
                    digits[i]++;
                    carry = false;
                }
                if (!carry) {
                    return digits;
                }
            }

            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}