package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[780] 到达终点
/* 1,1,3,5 */
public class ReachingPoints {
    public static void main(String[] args) {
        Solution solution = new ReachingPoints().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            if (tx < sx || ty < sy) return false;

            if (tx > ty) {
                if (ty == sy) {
                    return (tx - sx) % ty == 0;
                }
                return reachingPoints(sx, sy, tx % ty, ty);
            } else if (tx < ty) {
                if (tx == sx) {
                    return (ty - sy) % tx == 0;
                }
                return reachingPoints(sx, sy, tx, ty % tx);
            }

            return sx == tx && sy == ty;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}