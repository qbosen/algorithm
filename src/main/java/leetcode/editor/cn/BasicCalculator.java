package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//224 基本计算器
/* "1,+,1" */
public class BasicCalculator {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            // 符号
            Deque<Integer> ops = new LinkedList<>();
            ops.push(1);
            int sign = 1;

            int res = 0;
            int n = s.length();
            int i = 0;
            while (i < n) {
                if (s.charAt(i) == ' ') {
                    i++;
                } else if (s.charAt(i) == '+') {
                    sign = ops.peek();
                    i++;
                } else if (s.charAt(i) == '-') {
                    sign = -ops.peek();
                    i++;
                } else if (s.charAt(i) == '(') {
                    ops.push(sign);
                    i++;
                } else if (s.charAt(i) == ')') {
                    ops.pop();
                    i++;
                } else {
                    int num = 0;
                    while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        num = num * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    res += sign * num;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}