package leetcode.editor.cn;

//[2042] 检查句子中的数字是否递增
/* "1,box,has,3,blue,4,red,6,green,and,12,yellow,marbles" */
public class CheckIfNumbersAreAscendingInASentence {
    public static void main(String[] args) {
        Solution solution = new CheckIfNumbersAreAscendingInASentence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areNumbersAscending(String s) {
            int i = 0;
            int n = s.length();
            int prev = 0;
            while (i < n) {
                int j = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    j = j * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if (j != 0 && j <= prev) return false;
                prev = j;
                while (i < n && !Character.isDigit(s.charAt(i))) {
                    i++;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}