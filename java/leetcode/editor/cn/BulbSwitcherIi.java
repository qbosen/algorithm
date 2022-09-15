package leetcode.editor.cn;

//[672] 灯泡开关 Ⅱ
/* 1,1 */
public class BulbSwitcherIi {
    public static void main(String[] args) {
        Solution solution = new BulbSwitcherIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int flipLights(int n, int presses) {
            if (presses == 0) {
                return 1;
            }
            //特殊情况处理
            if (n == 1) {
                return 2;
            } else if (n == 2) {
                return presses == 1 ? 3 : 4;
            } else {
                return presses == 1 ? 4 : presses == 2 ? 7 : 8;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}