package leetcode.editor.cn;

//[1796] 字符串中第二大的数字
/* "dfa12321afd" */
public class SecondLargestDigitInAString {
    public static void main(String[] args) {
        Solution solution = new SecondLargestDigitInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int secondHighest(String s) {
            int first = -1, second = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    int num = c - '0';
                    if (num > first) {
                        second = first;
                        first = num;
                    } else if (num < first && num > second) {
                        second = num;
                    }
                }
            }
            return second;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}