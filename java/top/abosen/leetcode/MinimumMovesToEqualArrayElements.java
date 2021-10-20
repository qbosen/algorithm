package top.abosen.leetcode;

import java.util.*;
import top.abosen.leetcode.struct.*;

//[453] 最小操作次数使数组元素相等
/* [1,2,3] */
public class MinimumMovesToEqualArrayElements{
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToEqualArrayElements().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        int ans = 0;
        for (int num : nums) {
            ans += num - min;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}