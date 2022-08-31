package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//[946] 验证栈序列
/* [1,2,3,4,5],[4,5,3,2,1] */
public class ValidateStackSequences {
    public static void main(String[] args) {
        Solution solution = new ValidateStackSequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = pushed.length;
            for (int i = 0, j = 0; i < n; i++) {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}