package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[2016] 增量元素之间的最大差值
/* [7,1,5,4] */
public class MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {
        Solution solution = new MaximumDifferenceBetweenIncreasingElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumDifference(int[] nums) {
            int min = nums[0];
            int res = -1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > min) {
                    res = Math.max(res, nums[i] - min);
                } else {
                    min = nums[i];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}