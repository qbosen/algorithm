package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//[1805] 字符串中不同整数的数目
/* "a123bc34d8ef34" */
public class NumberOfDifferentIntegersInAString {
    public static void main(String[] args) {
        Solution solution = new NumberOfDifferentIntegersInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDifferentIntegers(String word) {
            Set<String> set = new HashSet<String>();
            int n = word.length(), p1 = 0, p2;
            while (true) {
                while (p1 < n && !Character.isDigit(word.charAt(p1))) {
                    p1++;
                }
                if (p1 == n) {
                    break;
                }
                p2 = p1;
                while (p2 < n && Character.isDigit(word.charAt(p2))) {
                    p2++;
                }
                while (p2 - p1 > 1 && word.charAt(p1) == '0') { // 去除前导 0
                    p1++;
                }
                set.add(word.substring(p1, p2));
                p1 = p2;
            }
            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}