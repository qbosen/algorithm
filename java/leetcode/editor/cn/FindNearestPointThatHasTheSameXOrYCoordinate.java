package leetcode.editor.cn;

//[1779] 找到最近的有相同 X 或 Y 坐标的点
/* 3,4,[[1,2],[3,1],[2,4],[2,3],[4,4]] */
public class FindNearestPointThatHasTheSameXOrYCoordinate {
    public static void main(String[] args) {
        Solution solution = new FindNearestPointThatHasTheSameXOrYCoordinate().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int result = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < points.length; i++) {
                int[] point = points[i];
                if (point[0] != x && point[1] != y) {
                    continue;
                }
                int distance = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                if (distance < minDistance) {
                    minDistance = distance;
                    result = i;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}