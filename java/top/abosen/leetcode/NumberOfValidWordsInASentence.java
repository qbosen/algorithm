package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[2047] 句子中的有效单词数
/* "cat,and,dog" */
public class NumberOfValidWordsInASentence {
    public static void main(String[] args) {
        Solution solution = new NumberOfValidWordsInASentence().new Solution();
        System.out.println(solution.countValidWords("alice and bob are playing stone-game10"));
        System.out.println(solution.countValidWords("cat and dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countValidWords(String sentence) {
            char[] chars = sentence.toCharArray();
            int n = chars.length;
            int l = 0, r = 0;
            int ret = 0;
            while (true) {
                while (l < n && chars[l] == ' ') {
                    l++;
                }
                if (l >= n) {
                    break;
                }
                r = l + 1;
                while (r < n && chars[r] != ' ') {
                    r++;
                }
                if (isValid(chars, l, r)) { // 判断根据空格分解出来的 token 是否有效
                    ret++;
                }
                l = r + 1;
            }
            return ret;
        }

        public boolean isValid(char[] chars, int l, int r) {
            boolean hasHyphens = false;
            for (int i = l; i < r; i++) {
                if (Character.isDigit(chars[i])) {
                    return false;
                } else if (chars[i] == '-') {
                    if (hasHyphens || i == 0 || i == r - 1 || !Character.isLetter(chars[i - 1]) || !Character.isLetter(chars[i + 1])) {
                        return false;
                    }
                    hasHyphens = true;
                } else if (chars[i] == '!' || chars[i] == '.' || chars[i] == ',') {
                    if (i != r - 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}