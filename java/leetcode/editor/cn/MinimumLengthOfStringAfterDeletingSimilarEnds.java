package leetcode.editor.cn;

//[1750] 删除字符串两端相同字符后的最短长度
/* "ca" */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        Solution solution = new MinimumLengthOfStringAfterDeletingSimilarEnds().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumLength(String s) {
            int n = s.length();
            // refer to chars not deleted
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) break;
                char c = s.charAt(i);
                while (i < n && s.charAt(i) == c) {
                    i++;
                }
                while (i < j && s.charAt(j) == c) {
                    j--;
                }
            }
            if (i > j) return 0;
            return (j - i + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}