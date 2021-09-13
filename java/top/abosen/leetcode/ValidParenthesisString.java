package top.abosen.leetcode;

//678 有效的括号字符串
public class ValidParenthesisString {
    public static void main(String[] args) {
        Solution solution = new ValidParenthesisString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValidString(String s) {
            // 评分法
            int min = 0, max = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    min++;
                    max++;
                } else if (c == ')') {
                    min--;
                    max--;
                } else {
                    min--;
                    max++;
                }
                // * 不能导致右括号过多
                if (min < 0) min = 0;
                // 右括号确实多了
                if (min > max) return false;
            }

            return min == 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}