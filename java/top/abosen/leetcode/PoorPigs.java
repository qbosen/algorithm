package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[458] 可怜的小猪
/* 1000,15,60 */
public class PoorPigs{
    public static void main(String[] args) {
        Solution solution = new PoorPigs().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int poorPigs(int n, int d, int t) {
        int k = t / d;
        return (int) Math.ceil(Math.log(n) / Math.log(k + 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}