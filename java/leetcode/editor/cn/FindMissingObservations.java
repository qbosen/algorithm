package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[2028] 找出缺失的观测数据
/* [3,2,4,3],4,2 */
public class FindMissingObservations {
    public static void main(String[] args) {
        Solution solution = new FindMissingObservations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int s = mean * (rolls.length + n);
            for (int roll : rolls) {
                s -= roll;
            }
            if (s < n || s > 6 * n)
                return new int[]{};
            int[] ans = new int[n];
            int d = s / n;
            for (int i = 0; i < s % n; i++)
                ans[i] = d + 1;
            for (int i = s % n; i < n; i++)
                ans[i] = d;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}