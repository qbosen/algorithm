package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[821] 字符的最短距离
/* "loveleetcode","e" */
public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        Solution solution = new ShortestDistanceToACharacter().new Solution();
        System.out.println(Arrays.toString(solution.shortestToChar("e", 'e')));
        System.out.println(Arrays.toString(solution.shortestToChar("loveleetcode", 'e')));
        System.out.println(Arrays.toString(solution.shortestToChar("aaab", 'b')));
        System.out.println(Arrays.toString(solution.shortestToChar("aaab", 'a')));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestToChar(String s, char c) {
            var ch = s.toCharArray();
            int n = ch.length;
            int[] res = new int[n];

            int lastC = -100000;
            for (int i = 0; i < n; i++) {
                if (ch[i] == c) {
                    for (int j = i; j > lastC && j >= 0; j--) {
                        res[j] = Math.min(i - j, j - lastC);
                    }
                    lastC = i;
                }
            }

            for (int i = Math.max(0, lastC); i < n; i++) {
                res[i] = i - lastC;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}