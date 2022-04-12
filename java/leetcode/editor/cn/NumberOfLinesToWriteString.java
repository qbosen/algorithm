package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[806] 写字符串需要的行数
/* [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10],"abcdefghijklmnopqrstuvwxyz" */
public class NumberOfLinesToWriteString {
    public static void main(String[] args) {
        Solution solution = new NumberOfLinesToWriteString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numberOfLines(int[] widths, String s) {
            int line = 1;
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                int width = widths[s.charAt(i) - 'a'];
                if (len + width > 100) {
                    line++;
                    len = width;
                } else {
                    len += width;
                }
            }
            return new int[]{line, len};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}