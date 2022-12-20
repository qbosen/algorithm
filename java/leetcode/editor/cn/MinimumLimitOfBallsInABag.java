package leetcode.editor.cn;

import java.util.Arrays;

//[1760] 袋子里最少数目的球
/* [9],2 */
public class MinimumLimitOfBallsInABag {
    public static void main(String[] args) {
        Solution solution = new MinimumLimitOfBallsInABag().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int left = 1, right = Arrays.stream(nums).max().getAsInt();
            int ans = 0;
            while (left <= right) {
                int y = (left + right) / 2;
                long ops = 0;
                for (int x : nums) {
                    ops += (x - 1) / y;
                }
                if (ops <= maxOperations) {
                    ans = y;
                    right = y - 1;
                } else {
                    left = y + 1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}