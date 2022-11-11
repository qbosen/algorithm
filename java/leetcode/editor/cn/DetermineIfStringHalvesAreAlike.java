package leetcode.editor.cn;

import java.util.Set;

//[1704] 判断字符串的两半是否相似
/* "book" */
public class DetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        Solution solution = new DetermineIfStringHalvesAreAlike().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        public boolean halvesAreAlike(String s) {
            int half = s.length() / 2;
            int a = 0, b = 0;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    if (i < half) a++;
                    else b++;
                }
            }
            return a == b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}