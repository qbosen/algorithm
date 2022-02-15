package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1380] 矩阵中的幸运数
/* [[3,7,8],[9,11,13],[15,16,17]] */
public class LuckyNumbersInAMatrix{
    public static void main(String[] args) {
        Solution solution = new LuckyNumbersInAMatrix().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Map<Integer, Integer> maxInCol = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int[] row : matrix) {
            // 该行中最小值的列号
            int colIdx = 0;
            for (int j = 0; j < n; j++) {
                if (row[j] < row[colIdx]) {
                    colIdx = j;
                }
            }
            int maxColValue = maxInCol.computeIfAbsent(colIdx, (col) -> {
                int max = matrix[0][col];
                for (int k = 1; k < m; k++) {
                    max = Math.max(max, matrix[k][col]);
                }
                return max;
            });
            if (row[colIdx] == maxColValue) {
                res.add(maxColValue);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}