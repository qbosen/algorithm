package leetcode.editor.cn;

//[775] 全局倒置与局部倒置
/* [1,0,2] */
public class GlobalAndLocalInversions {
    public static void main(String[] args) {
        Solution solution = new GlobalAndLocalInversions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            int max = nums[0];
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] < max) return false;
                max = Math.max(max, nums[i - 1]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}