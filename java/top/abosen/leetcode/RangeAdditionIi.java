package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[598] 范围求和 II
/* 3,3,[[2,2],[3,3]] */
public class RangeAdditionIi{
    public static void main(String[] args) {
        Solution solution = new RangeAdditionIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int mm = m, mn = n;
        for (int[] op : ops) {
            mm = Math.min(mm, op[0]);
            mn = Math.min(mn, op[1]);
        }
        return mm * mn;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}