package leetcode.editor.cn;

//[1422] 分割字符串的最大得分
/* "011101" */
public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        Solution solution = new MaximumScoreAfterSplittingAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxScore(String s) {
            char[] chars = s.toCharArray();
            int score = chars[0] == '0' ? 1 : 0;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == '1') {
                    score++;
                }
            }

            int max = score;
            for (int i = 1; i < chars.length - 1; i++) {
                if (chars[i] == '0') {
                    score++;
                } else {
                    score--;
                }
                max = Math.max(score, max);
            }
            return max;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}