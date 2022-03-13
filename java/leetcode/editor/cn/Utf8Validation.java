package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[393] UTF-8 编码验证
/* [197,130,1] */
public class Utf8Validation {
    public static void main(String[] args) {
        Solution solution = new Utf8Validation().new Solution();
        System.out.println(solution.validUtf8(new int[]{145}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validUtf8(int[] data) {
            int idx = 0, n = data.length;
            while (idx < n) {
                //1. 计算该字符长度
                int l = 0;
                int firstByte = data[idx];
                for (int i = 7; i >= 3; i--) {
                    if ((firstByte & (1 << i)) == 0) {
                        break;
                    } else {
                        l++;
                    }
                }
                // l=0表示1字节
                if (l == 1 || l > 4) return false;
                //2. check 接下来的 l-1 个字节
                for (int i = 0; i < l - 1; i++) {
                    idx++;
                    if (idx >= n || ((data[idx] >> 7) & 1) != 1 || ((data[idx] >> 6) & 1) != 0) {
                        return false;
                    }
                }

                idx++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}