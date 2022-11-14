package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//[805] 数组的均值分割
/* [1,2,3,4,5,6,7,8] */
public class SplitArrayWithSameAverage {
    public static void main(String[] args) {
        Solution solution = new SplitArrayWithSameAverage().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean splitArraySameAverage(int[] nums) {
            if (nums.length == 1) {
                return false;
            }
            int n = nums.length, m = n / 2;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            for (int i = 0; i < n; i++) {
                nums[i] = nums[i] * n - sum;
            }

            Set<Integer> left = new HashSet<Integer>();
            for (int i = 1; i < (1 << m); i++) {
                int tot = 0;
                for (int j = 0; j < m; j++) {
                    if ((i & (1 << j)) != 0) {
                        tot += nums[j];
                    }
                }
                if (tot == 0) {
                    return true;
                }
                left.add(tot);
            }
            int rsum = 0;
            for (int i = m; i < n; i++) {
                rsum += nums[i];
            }
            for (int i = 1; i < (1 << (n - m)); i++) {
                int tot = 0;
                for (int j = m; j < n; j++) {
                    if ((i & (1 << (j - m))) != 0) {
                        tot += nums[j];
                    }
                }
                if (tot == 0 || (rsum != tot && left.contains(-tot))) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}