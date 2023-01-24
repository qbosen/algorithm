package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1828] 统计一个圆中点的数目
/* [[1,3],[3,3],[5,3],[2,2]],[[2,3,1],[4,3,1],[1,1,2]] */
public class QueriesOnNumberOfPointsInsideACircle{
    public static void main(String[] args) {
        Solution solution = new QueriesOnNumberOfPointsInsideACircle().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            for (int[] point : points) {
                int dx = query[0] - point[0];
                int dy = query[1] - point[1];
                if (dx * dx + dy * dy <= query[2] * query[2]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}