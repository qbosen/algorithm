package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[824] 山羊拉丁文
/* "I,speak,Goat,Latin" */
public class GoatLatin {
    public static void main(String[] args) {
        Solution solution = new GoatLatin().new Solution();
        System.out.println(solution.toGoatLatin("I speak Goat Latin"));
        System.out.println(solution.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toGoatLatin(String s) {
            int n = s.length();
            int i = 0;
            int word = 1;
            var sb = new StringBuilder();
            while (i < n) {
                char first = s.charAt(i);
                char cur;
                if (
                        first != 'a' && first != 'e' && first != 'i' && first != 'o' && first != 'u' &&
                        first != 'A' && first != 'E' && first != 'I' && first != 'O' && first != 'U'
                ) {
                    i++;
                    while (i < n && (cur = s.charAt(i)) != ' ') {
                        sb.append(cur);
                        i++;
                    }
                    sb.append(first);
                } else {
                    while (i < n && (cur = s.charAt(i)) != ' ') {
                        sb.append(cur);
                        i++;
                    }
                }
                sb.append("ma").append("a".repeat(word));
                if (i < n) sb.append(' ');
                word++;
                i++;

            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}