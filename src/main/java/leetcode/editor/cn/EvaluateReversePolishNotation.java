package leetcode.editor.cn;

// 150 逆波兰表达式求值
/* ["2","1","+","3","*"] */

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            for (String token : tokens) {
                if ("+".equals(token)) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                } else if ("-".equals(token)) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                } else if ("*".equals(token)) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                } else if ("/".equals(token)) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                } else {
                    int num = 0;
                    int sign = 1;
                    for (int i = 0; i < token.length(); i++) {
                        char c = token.charAt(i);
                        if (c == '+') {
                            sign = 1;
                        } else if (c == '-') {
                            sign = -1;
                        } else {
                            num = num * 10 + (c - '0');
                        }
                    }
                    stack.push(sign * num);
                }
            }
            return stack.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}