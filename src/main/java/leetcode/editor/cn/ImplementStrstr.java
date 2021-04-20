package leetcode.editor.cn;

//28 实现 strStr()
/* "hello","ll" */
public class ImplementStrstr {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();

            for (int i = 0; i + m <= n; i++) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}