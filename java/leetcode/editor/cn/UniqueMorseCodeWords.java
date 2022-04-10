package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//[804] 唯一摩尔斯密码词
/* ["gin","zen","gig","msg"] */
public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        Solution solution = new UniqueMorseCodeWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public static final String[] CODE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};

        public int uniqueMorseRepresentations(String[] words) {
            Set<String> res = new HashSet<>();
            for (String word : words) {
                StringBuilder code = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    code.append(CODE[word.charAt(i) - 'a']);
                }
                res.add(code.toString());
            }
            return res.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}