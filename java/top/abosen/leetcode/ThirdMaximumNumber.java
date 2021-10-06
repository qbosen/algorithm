package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[414] 第三大的数
/* [3,2,1] */
public class ThirdMaximumNumber{
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        Integer a = null, b = null, c = null;
        for (int num : nums) {
            if (a == null || num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && (b == null || num > b)) {
                c = b;
                b = num;
            } else if (b != null && b > num && (c == null || num > c)) {
                c = num;
            }
        }
        return c == null ? a : c;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}