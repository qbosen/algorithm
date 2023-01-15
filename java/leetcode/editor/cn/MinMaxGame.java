package leetcode.editor.cn;

//[2293] 极大极小游戏
/* [1,3,5,2,4,8,2,2] */
public class MinMaxGame {
    public static void main(String[] args) {
        Solution solution = new MinMaxGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMaxGame(int[] nums) {
            int n = nums.length;
            while (n != 1) {
                n = n / 2;
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0)
                        nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                    else
                        nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            return nums[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}