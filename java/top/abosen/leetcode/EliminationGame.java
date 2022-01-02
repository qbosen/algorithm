package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[390] 消除游戏
/* 9 */
public class EliminationGame{
    public static void main(String[] args) {
        Solution solution = new EliminationGame().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}