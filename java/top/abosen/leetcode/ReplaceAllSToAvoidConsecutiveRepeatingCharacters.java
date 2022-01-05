package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[1576] 替换所有的问号
/* "?zs" */
public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String modifyString(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            // 一定是三者之一
            char[] abc = new char[]{'a', 'b', 'c'};
            for (int i = 0; i < n; i++) {
                if (chars[i] == '?') {
                    for (char c : abc) {
                        if (i > 0 && chars[i - 1] == c) continue;
                        if (i < n - 1 && chars[i + 1] == c) continue;
                        chars[i] = c;
                        break;
                    }
                }
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}