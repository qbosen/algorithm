package top.abosen.leetcode;

//[807] 保持城市天际线
/* [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]] */
public class MaxIncreaseToKeepCitySkyline {
    public static void main(String[] args) {
        Solution solution = new MaxIncreaseToKeepCitySkyline().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int n = grid.length;
            int[] maxI = new int[n];
            int[] maxJ = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    maxI[i] = Math.max(maxI[i], grid[i][j]);
                    maxJ[j] = Math.max(maxJ[j], grid[i][j]);
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res += Math.min(maxI[i], maxJ[j]) - grid[i][j];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}