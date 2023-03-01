package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[2373] 矩阵中的局部最大值
/* [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]] */
public class LargestLocalValuesInAMatrix{
    public static void main(String[] args) {
        Solution solution = new LargestLocalValuesInAMatrix().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        res[i][j] = Math.max(res[i][j], grid[x][y]);
                    }
                }
            }
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}