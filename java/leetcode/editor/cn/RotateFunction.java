package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[396] 旋转函数
/* [4,3,2,6] */
public class RotateFunction {
    public static void main(String[] args) {
        Solution solution = new RotateFunction().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRotateFunction(int[] nums) {
            int sum = 0, fk = 0;
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                fk += nums[i] * i;
                sum += nums[i];
            }
            int res = fk;
            // f[i] = f[i-1] + sum - n * nums[n-i]
            for (int i = 1; i < n; i++) {
                fk = fk + sum - n * nums[n - i];
                res = Math.max(res, fk);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}