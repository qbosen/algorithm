package top.abosen.leetcode;

//[709] 转换成小写字母
/* "Hello" */
public class ToLowerCase {
    public static void main(String[] args) {
        Solution solution = new ToLowerCase().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toLowerCase(String s) {
            char[] chars = new char[s.length()];
            int diff = 'A' - 'a';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    c = (char) (c - diff);
                }
                chars[i] = c;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}