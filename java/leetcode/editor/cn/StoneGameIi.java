package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1140] 石子游戏 II
/* [2,7,9,4,4] */
public class StoneGameIi{
    public static void main(String[] args) {
        Solution solution = new StoneGameIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int sum = 0;
        // [i..n], M=j
        int[][] dp = new int[n][n + 1];
        for (int i = n-1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= n; M++) {
                if(i + 2*M >=n) dp[i][M] = sum;
                else{
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }

        return dp[0][1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}