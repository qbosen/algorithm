package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[1996] 游戏中弱角色的数量
/* [[5,5],[6,3],[3,6]] */
public class TheNumberOfWeakCharactersInTheGame{
    public static void main(String[] args) {
        Solution solution = new TheNumberOfWeakCharactersInTheGame().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfWeakCharacters(int[][] ps) {
        int n = ps.length, ans = 0;
        Arrays.sort(ps, (a, b)->{
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        for (int i = 0, max = ps[0][1]; i < n; ) {
            int j = i;
            while (j < n && ps[j][0] == ps[i][0]) {
                if (i != 0 && ps[j][1] < max) ans++;
                j++;
            }
            max = Math.max(max, ps[i][1]); i = j;
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}