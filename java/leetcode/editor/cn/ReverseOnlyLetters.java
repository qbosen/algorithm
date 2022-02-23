package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[917] 仅仅反转字母
/* "ab-cd" */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
        System.out.println(solution.reverseOnlyLetters("ab-cd"));
        System.out.println(solution.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(solution.reverseOnlyLetters("7_28]"));
        System.out.println(solution.reverseOnlyLetters("?6C40E]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            for (int i = 0, j = n - 1; i < j; ) {
                while (i < j && !isLetter(chars[i])) {
                    i++;
                }
                while (i < j && !isLetter(chars[j])) {
                    j--;
                }
                if (i < j) {
                    char t = chars[i];
                    chars[i] = chars[j];
                    chars[j] = t;
                }
                i++;
                j--;
            }
            return String.valueOf(chars);
        }

        private boolean isLetter(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}