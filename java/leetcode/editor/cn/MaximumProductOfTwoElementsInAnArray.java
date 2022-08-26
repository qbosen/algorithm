package leetcode.editor.cn;

//[1464] 数组中两元素的最大乘积
/* [3,4,5,2] */
public class MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfTwoElementsInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int a = -1, b = -1;
            for (int x : nums) {
                if (x > a) {
                    b = a;
                    a = x;
                } else if (x > b) {
                    b = x;
                }
            }
            return (a - 1) * (b - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}