package leetcode.editor.cn;

//[1252] 奇数值单元格的数目
/* 2,3,[[0,1],[1,1]] */
public class CellsWithOddValuesInAMatrix {
    public static void main(String[] args) {
        Solution solution = new CellsWithOddValuesInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int oddCells(int m, int n, int[][] indices) {
            int[] row = new int[m], col = new int[n];
            for (int[] each : indices) {
                row[each[0]]++;
                col[each[1]]++;
            }

            int ro = 0, co = 0;
            for (int i : row) {
                ro += i % 2;
            }
            for (int i : col) {
                co += i % 2;
            }
            int re = m - ro, ce = n - co;

            return ro * ce + re * co;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}