package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[2038] 如果相邻两个颜色均相同则删除当前颜色
/* "AAABABB" */
public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    public static void main(String[] args) {
        Solution solution = new RemoveColoredPiecesIfBothNeighborsAreTheSameColor().new Solution();
        System.out.println(solution.winnerOfGame("AAABABB"));
        System.out.println(solution.winnerOfGame("AA"));
        System.out.println(solution.winnerOfGame("ABBBBBBBAA"));
        System.out.println(solution.winnerOfGame("BBAA"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean winnerOfGame(String colors) {
            int ca = 0, cb = 0, seq = 1;
            int i = 1;
            while (i < colors.length()) {
                while (i < colors.length() && colors.charAt(i) == colors.charAt(i - 1)) {
                    i++;
                    seq++;
                }
                if (seq > 2) {
                    if (colors.charAt(i - 1) == 'A') {
                        ca += seq - 2;
                    } else {
                        cb += seq - 2;
                    }
                }
                seq = 1;
                i++;
            }

            return ca > cb;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}