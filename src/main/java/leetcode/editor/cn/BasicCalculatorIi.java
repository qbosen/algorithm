package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//227 基本计算器 II
/* "3+2*2" */
public class BasicCalculatorIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        int i;
        String s;

        public int calculate(String s) {
            Deque<Integer> stack = new LinkedList<>();
            this.s = s;
            n = s.length();
            i = 0;
            int sign = 1;
            while (i < n) {
                if (s.charAt(i) == ' ') {
                    i++;
                } else if (s.charAt(i) == '+') {
                    sign = 1;
                    i++;
                } else if (s.charAt(i) == '-') {
                    sign = -1;
                    i++;
                } else if (s.charAt(i) == '*') {
                    int prev = stack.pop();
                    i++;
                    int next = loadNext();
                    stack.push(prev * next);
                } else if (s.charAt(i) == '/') {
                    int prev = stack.pop();
                    i++;
                    int next = loadNext();
                    stack.push(prev / next);
                } else {
                    stack.push(sign * loadNext());
                }
            }
            int res = 0;
            for (Integer num : stack) {
                res += num;
            }
            return res;
        }

        private int loadNext() {
            int num = 0;
            int sign = 1;
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            if (s.charAt(i) == '+') i++;
            if (s.charAt(i) == '-') {
                i++;
                sign = -1;
            }
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
                i++;
            }
            return sign * num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}