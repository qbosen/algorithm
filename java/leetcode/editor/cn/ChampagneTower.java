package leetcode.editor.cn;

//[799] 香槟塔
/* 1,1,1 */
public class ChampagneTower {
    public static void main(String[] args) {
        Solution solution = new ChampagneTower().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            double[] row = {poured};
            for (int i = 1; i <= query_row; i++) {
                double[] nextRow = new double[i + 1];
                for (int j = 0; j < i; j++) {
                    double volume = row[j];
                    if (volume > 1) {
                        nextRow[j] += (volume - 1) / 2;
                        nextRow[j + 1] += (volume - 1) / 2;
                    }
                }
                row = nextRow;
            }
            return Math.min(1, row[query_glass]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}