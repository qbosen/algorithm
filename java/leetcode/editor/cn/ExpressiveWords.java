package leetcode.editor.cn;

//[809] 情感丰富的文字
/* "heeellooo",["hello",,"hi",,"helo"] */
public class ExpressiveWords {
    public static void main(String[] args) {
        Solution solution = new ExpressiveWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int expressiveWords(String s, String[] words) {
            int n = s.length(), ans = 0;
            out:
            for (String word : words) {
                int m = word.length(), i = 0, j = 0;
                while (i < n && j < m) {
                    if (s.charAt(i) != word.charAt(j)) continue out;
                    int a = i, b = j;
                    while (a < n && s.charAt(a) == s.charAt(i)) a++;
                    while (b < m && word.charAt(b) == word.charAt(j)) b++;
                    a -= i;
                    b -= j;
                    if (a != b && (b > a || a < 3)) continue out;
                    i += a;
                    j += b;
                }
                if (i == n && j == m) ans++;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}