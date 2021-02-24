package leetcode.editor.cn;
// 字符串转换整数 (atoi)
// 8

public class StringToIntegerAtoi {
    public static void run(Solution solution, int expect, String str) {
        String pstr = str;
        int result = solution.myAtoi(pstr);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        run(solution, 42, "42");
        run(solution, 0, "words and 987");
        run(solution, Integer.MIN_VALUE, "-91283472332");
        run(solution, Integer.MAX_VALUE, "+91283472332");
        run(solution, 12345678, "000000000012345678");
        run(solution, 10, "010");
        run(solution, 2147483646, "2147483646");
        run(solution, 2147483647, "21474836467");
        run(solution, 2147483647, "21474836468");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String str) {
            char[] chars = str.toCharArray();
            boolean positive = true;
            int i = 0;
            // 找到第一个数字
            for (; i < chars.length; i++) {
                char aChar = chars[i];
                if (aChar == ' ') continue;
                if (aChar == '+') {
                    i++;
                    break;
                } else if (aChar == '-') {
                    i++;
                    positive = false;
                    break;
                } else if (aChar >= '0' && aChar <= '9') {
                    break;
                } else {
                    return 0;
                }
            }

            int result = 0;
            final int BOUND = Integer.MAX_VALUE / 10;
            final int VALUE_BOUND = positive ? 7 : 8;
            for (int count = 0; i < chars.length; i++) {
                int v = chars[i] - '0';
                if (v < 0 || v > 9)
                    break;
                if (count == 0 && v == 0) {
                    continue;
                }
                count++;
                if (count < 9 || result < BOUND || result == BOUND && v <= VALUE_BOUND) {
                    result = v + result * 10;
                } else {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            return result * (positive ? 1 : -1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}