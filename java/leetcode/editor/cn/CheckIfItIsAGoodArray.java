package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1250] 检查「好数组」
/* [12,5,7,23] */
public class CheckIfItIsAGoodArray{
    public static void main(String[] args) {
        Solution solution = new CheckIfItIsAGoodArray().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isGoodArray(int[] nums) {

        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(gcd == 1) return true;
            gcd = gcd(nums[i], gcd);
        }
        return gcd == 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}