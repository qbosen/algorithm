package leetcode.editor.cn;

//[1662] 检查两个字符串数组是否相等
/* ["ab",,"c"],["a",,"bc"] */
public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        Solution solution = new CheckIfTwoStringArraysAreEquivalent().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int w1i = 0, w1j = 0, w2i = 0, w2j = 0;
            while (w1i < word1.length && w2i < word2.length) {
                if (w1j >= word1[w1i].length()) {
                    w1i++;
                    w1j = 0;
                }
                if (w2j >= word2[w2i].length()) {
                    w2i++;
                    w2j = 0;
                }
                if (w1i >= word1.length || w2i >= word2.length) {
                    return w1i == word1.length && w1j == 0 && w2i == word2.length && w2j == 0;
                }
                char c1 = word1[w1i].charAt(w1j);
                char c2 = word2[w2i].charAt(w2j);
                if (c1 != c2) {
                    return false;
                }
                w1j++;
                w2j++;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}