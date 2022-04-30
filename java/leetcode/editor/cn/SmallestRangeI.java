package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[908] 最小差值 I
/* [1],0 */
public class SmallestRangeI{
    public static void main(String[] args) {
        Solution solution = new SmallestRangeI().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return Math.max(0, max - min - 2 * k);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}