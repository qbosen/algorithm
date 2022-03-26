package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[682] 棒球比赛
/* ["5","2","C","D","+"] */
public class BaseballGame {
    public static void main(String[] args) {
        Solution solution = new BaseballGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calPoints(String[] ops) {
            int[] cache = new int[ops.length];
            int i = 0;
            for (String op : ops) {
                switch (op) {
                    case "C" -> cache[--i] = 0;
                    case "D" -> {
                        cache[i] = cache[i - 1] * 2;
                        i++;
                    }
                    case "+" -> {
                        cache[i] = cache[i - 1] + cache[i - 2];
                        i++;
                    }
                    default -> cache[i++] = Integer.parseInt(op);
                }
            }
            return Arrays.stream(cache).sum();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}