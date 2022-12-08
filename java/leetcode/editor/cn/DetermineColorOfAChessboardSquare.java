package leetcode.editor.cn;

//[1812] 判断国际象棋棋盘中一个格子的颜色
/* "a1" */
public class DetermineColorOfAChessboardSquare {
    public static void main(String[] args) {
        Solution solution = new DetermineColorOfAChessboardSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean squareIsWhite(String coordinates) {
            int x = coordinates.charAt(0) - 'a';
            int y = coordinates.charAt(1) - '1';
            return (x % 2) != (y % 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}