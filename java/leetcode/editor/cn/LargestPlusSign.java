package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[764] 最大加号标志
/* 5,[[4,2]] */
public class LargestPlusSign{
    public static void main(String[] args) {
        Solution solution = new LargestPlusSign().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] g = new int[n + 10][n + 10];
        for (int i = 1; i <= n; i++) Arrays.fill(g[i], 1);
        for (int[] info : mines) g[info[0] + 1][info[1] + 1] = 0;
        int[][] a = new int[n + 10][n + 10], b = new int[n + 10][n + 10], c = new int[n + 10][n + 10], d = new int[n + 10][n + 10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j] == 1) {
                    a[i][j] = a[i - 1][j] + 1;
                    b[i][j] = b[i][j - 1] + 1;
                }
                if (g[n + 1 - i][n + 1 - j] == 1) {
                    c[n + 1 - i][n + 1 - j] = c[n + 2 - i][n + 1 - j] + 1;
                    d[n + 1 - i][n + 1 - j] = d[n + 1 - i][n + 2 - j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, Math.min(Math.min(a[i][j], b[i][j]), Math.min(c[i][j], d[i][j])));
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}