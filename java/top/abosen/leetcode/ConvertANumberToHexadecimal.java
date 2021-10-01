package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[405] 数字转换为十六进制数
/* 26 */
public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        Solution solution = new ConvertANumberToHexadecimal().new Solution();
        System.out.println(solution.toHex(26));
        System.out.println(solution.toHex(-1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toHex(int num) {
            if(num==0) return "0";
            StringBuilder sb = new StringBuilder();
            while (num != 0) {
                int m = num & 15;
                if (m <= 9) {
                    sb.append(m);
                } else {
                    sb.append((char)('a' + m - 10));
                }
                num = num >>> 4;
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}