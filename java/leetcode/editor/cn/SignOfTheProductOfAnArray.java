package leetcode.editor.cn;

//[1822] 数组元素积的符号
/* [-1,-2,-3,-4,3,2,1] */
public class SignOfTheProductOfAnArray {
    public static void main(String[] args) {
        Solution solution = new SignOfTheProductOfAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arraySign(int[] nums) {
            boolean negative = false;
            for (int num : nums) {
                if (num == 0) {
                    return 0;
                } else if (num < 0) {
                    negative = !negative;
                }
            }

            return negative ? -1 : 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}