package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//[856] 括号的分数
/* "()" */
public class ScoreOfParentheses {
    public static void main(String[] args) {
        Solution solution = new ScoreOfParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses(String s) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(0);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    deque.push(0);
                } else {
                    int prev = deque.pop();
                    int num = (prev == 0 ? 1 : (2 * prev)) + deque.pop();
                    deque.push(num);
                }
            }
            return deque.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}