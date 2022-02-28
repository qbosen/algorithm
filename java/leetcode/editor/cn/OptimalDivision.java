package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[553] 最优除法
/* [1000,100,10,2] */
public class OptimalDivision {
    public static void main(String[] args) {
        Solution solution = new OptimalDivision().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String optimalDivision(int[] nums) {
            int n = nums.length;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[0]);
            for (int i = 1; i < n; i++) {
                if (i == 1 && n > 2) {
                    sb.append("/(").append(nums[i]);
                } else {
                    sb.append("/").append(nums[i]);
                }
            }
            return nums.length > 2 ? sb.append(")").toString() : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}