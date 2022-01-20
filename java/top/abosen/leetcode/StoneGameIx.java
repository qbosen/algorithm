package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[2029] 石子游戏 IX
/* [2,1] */
public class StoneGameIx{
    public static void main(String[] args) {
        Solution solution = new StoneGameIx().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnts = new int[3];
        for (int i : stones) cnts[i % 3]++;
        return cnts[0] % 2 == 0 ? !(cnts[1] == 0 || cnts[2] == 0) : !(Math.abs(cnts[1] - cnts[2]) <= 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}