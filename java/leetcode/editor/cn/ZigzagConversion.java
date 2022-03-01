package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[6] Z 字形变换
/* "PAYPALISHIRING",3 */
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            int n = s.length();
            if (n == 1 || numRows == 1) return s;
            char[] res = new char[n];
            int idx = 0, offset = 2 * (numRows - 1);

            for (int i = 0; i < numRows; i++) {
                // 首尾行只有一个
                if (i == 0 || i == numRows - 1) {
                    int pos = i;
                    while (pos < n) {
                        res[idx++] = s.charAt(pos);
                        pos += offset;
                    }
                } else {
                    // 每行两个
                    int pos1 = i, pos2 = 2 * numRows - i - 2;
                    while (pos1 < n || pos2 < n) {
                        if (pos1 < n) {
                            res[idx++] = s.charAt(pos1);
                            pos1 += offset;
                        }
                        if (pos2 < n) {
                            res[idx++] = s.charAt(pos2);
                            pos2 += offset;
                        }
                    }
                }
            }
            return new String(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}