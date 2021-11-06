package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[268] 丢失的数字
/* [3,0,1] */
public class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                res = res ^ i ^ nums[i];
            }
            res ^= n;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}