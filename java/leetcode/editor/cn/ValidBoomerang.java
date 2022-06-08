package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1037] 有效的回旋镖
/* [[1,1],[2,3],[3,2]] */
public class ValidBoomerang{
    public static void main(String[] args) {
        Solution solution = new ValidBoomerang().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBoomerang(int[][] points) {
        if(isPointSame(points[0], points[1]) || isPointSame(points[1], points[2])){
            return false;
        }

        int x1= points[1][0] - points[0][0], x2 = points[2][0] - points[0][0];
        int y1= points[1][1] - points[0][1], y2 = points[2][1] - points[0][1];

        return !(x1 * y2 == x2 * y1);
    }

    private boolean isPointSame(int[] pointA, int [] pointB) {
        return pointA[0] == pointB[0] && pointA[1] == pointB[1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}