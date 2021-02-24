package leetcode.editor.cn;
// 有效括号的嵌套深度
// 1111
// "(()())"

import java.util.Arrays;

public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    public static void run(Solution solution, String expect, String seq) {
        String seq_ = seq;
        int[] result = solution.maxDepthAfterSplit(seq_);
        System.out.println(expect + "=" + Arrays.toString(result));
    }

    public static void main(String[] args) {
        Solution solution = new MaximumNestingDepthOfTwoValidParenthesesStrings().new Solution();
        run(solution, "[1,0,0,0,0,1]", "(()())");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            int stackDepth = 0;
            int[] result = new int[seq.length()];
            for (int i = 0; i < seq.length(); i++) {
                if (seq.charAt(i) == '(') {
                    result[i] = ++stackDepth % 2;
                } else {
                    result[i] = stackDepth-- % 2;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}