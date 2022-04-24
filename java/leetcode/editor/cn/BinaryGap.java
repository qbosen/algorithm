package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[868] 二进制间距
/* 22 */
public class BinaryGap {
    public static void main(String[] args) {
        Solution solution = new BinaryGap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int binaryGap(int n) {
            int last = -1;
            int res = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    if (last != -1) {
                        res = Math.max(res, i - last);
                    }
                    last = i;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}