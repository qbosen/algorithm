package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[798] 得分最高的最小轮调
/* [2,3,1,4,0] */
public class SmallestRotationWithHighestScore {
    public static void main(String[] args) {
        Solution solution = new SmallestRotationWithHighestScore().new Solution();
        solution.bestRotation(new int[]{2,3,1,4,0});
        solution.bestRotation(new int[]{1,3,0,2,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bestRotation(int[] nums) {
            int n = nums.length;
            int[] diff = new int[n+1];
            for (int i = 0; i < n; i++) {
                if (nums[i] <= i) {
                    diff[0]++;
                    diff[i - nums[i] + 1 ]--;
                    diff[i + 1]++;
                } else {
                    diff[i + 1]++;
                    diff[n - nums[i] + i + 1]--;
                }
            }

            int score = 0;
            int max = 0;
            int res = 0;

            for (int i = 0; i < n; i++) {
                score += diff[i];
                if (score > max) {
                    max = score;
                    res = i;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}