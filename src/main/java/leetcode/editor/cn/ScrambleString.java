package leetcode.editor.cn;

import java.util.Arrays;

//87 扰乱字符串
/* "great","rgeat" */
public class ScrambleString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // int[i][j][k]: i开始 和 j开始的 k长 双串的memo结果， -1:false,0:un-memo, 1:true
        int[][][] memo;
        String s1, s2;
        int[] charCounter;

        public boolean isScramble(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
            int length = s1.length();
            this.memo = new int[length][length][length + 1];
            this.charCounter = new int[26];
            return dfs(0, 0, length);
        }

        private boolean dfs(int i1, int i2, int length) {
            // 备忘录优化
            if (memo[i1][i2][length] != 0) {
                return memo[i1][i2][length] == 1;
            }
            // 字符串相等
            if (equals(i1, i2, length)) {
                memo[i1][i2][length] = 1;
                return true;
            }
            // 统计字符数量不同
            if (!checkChars(i1, i2, length)) {
                memo[i1][i2][length] = -1;
                return false;
            }

            // 枚举分割
            for (int i = 1; i < length; i++) {
                // 不交换
                if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i)) {
                    memo[i1][i2][length] = 1;
                    return true;
                }

                // 交换 (i1, i1+i, i1+length)  (i2, i2+length-i, i2+length)
                if (dfs(i1, i2 + length - i, i) && dfs(i1 + i, i2, length - i)) {
                    memo[i1][i2][length] = 1;
                    return true;
                }
            }

            memo[i1][i2][length] = -1;
            return false;
        }

        private boolean equals(int i1, int i2, int length) {
            for (int i = 0; i < length; i++) {
                if (s1.charAt(i1 + i) != s2.charAt(i2 + i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkChars(int i1, int i2, int length) {
            Arrays.fill(charCounter, 0);
            for (int i = 0; i < length; i++) {
                charCounter[s1.charAt(i1 + i) - 'a']++;
                charCounter[s2.charAt(i2 + i) - 'a']--;
            }
            for (int cnt : charCounter) {
                if (cnt != 0) return false;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}