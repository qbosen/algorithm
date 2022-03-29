package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1004] 最大连续1的个数 III
/* [1,1,1,0,0,0,1,1,1,1,0],2 */
public class MaxConsecutiveOnesIii{
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int l = 0, r = 0;
        int zeros = 0;
        while (r < n) {
            if (nums[r] == 0)
                zeros ++;
            while (zeros > k) {
                if (nums[l++] == 0)
                    zeros --;
            }
            res = Math.max(res, r - l + 1);
            r ++;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}