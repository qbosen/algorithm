package top.abosen.leetcode;

import java.util.*;
import top.abosen.leetcode.struct.*;

//[1995] 统计特殊四元组
/* [1,2,3,6] */
public class CountSpecialQuadruplets{
    public static void main(String[] args) {
        Solution solution = new CountSpecialQuadruplets().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) ans++;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}