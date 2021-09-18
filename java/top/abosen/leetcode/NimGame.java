package top.abosen.leetcode;

//[292] Nim 游戏
/* 4 */
public class NimGame {
    public static void main(String[] args) {
        Solution solution = new NimGame().new Solution();
        for (int i = 1; i < 128; i++) {
            System.out.println("i:" + i + "," + solution.canWinNim(i));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canWinNim(int n) {
            // 从 canWinNim_exceeded 可以知道 是4的周期
            return n % 4 != 0;
        }

        public boolean canWinNim_exceeded(int n) {
            if (n <= 3) return true;
            boolean a = true, b = true, c = true;
            // 前3步有必输的一步，那么当前就必赢
            for (int i = 4; i <= n; i++) {
                boolean t = (!a || !b || !c);
                a = b;
                b = c;
                c = t;
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}