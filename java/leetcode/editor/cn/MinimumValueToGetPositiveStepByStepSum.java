package leetcode.editor.cn;

//[1413] 逐步求和得到正数的最小值
/* [-3,2,-3,4,2], */
public class MinimumValueToGetPositiveStepByStepSum {
    public static void main(String[] args) {
        Solution solution = new MinimumValueToGetPositiveStepByStepSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minStartValue(int[] nums) {
            int min = Integer.MAX_VALUE, sum = 0;

            for (int num : nums) {
                sum += num;
                if (sum < min) {
                    min = sum;
                }
            }
            int res = 1 - min;
            return res > 0 ? res : 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}