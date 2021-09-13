package top.abosen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//[20] 有效的括号
/* "()" */
public class ValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    deque.push(c);
                } else {
                    if (deque.isEmpty()) return false;
                    char p = deque.poll();
                    if ((p != '(' || c != ')') && (p != '[' || c != ']') && (p != '{' || c != '}')) {
                        return false;
                    }
                }
            }
            return deque.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}