package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[2000] 反转单词前缀
/* "abcdefd","d" */
public class ReversePrefixOfWord {
    public static void main(String[] args) {
        Solution solution = new ReversePrefixOfWord().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reversePrefix(String word, char ch) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ch) {
                    for (int j = 0; j <= i; j++) {
                        chars[j] = word.charAt(i - j);
                    }
                    break;
                }
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}