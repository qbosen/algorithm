package leetcode.editor.cn;

//395 至少有 K 个重复字符的最长子串
/* "aaabb",3 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            return dfs(s, 0, s.length(), k);
        }

        private int dfs(String s, int start, int stop, int k) {
            if (stop - start < k) return 0;
            int[] count = new int[26];
            for (int i = start; i < stop; i++) {
                count[s.charAt(i) - 'a']++;
            }
            char split = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0 && count[i] < k) {
                    split = (char) ('a' + i);
                    break;
                }
            }

            // 没有小于k的
            if (split == 0) return stop - start;

            int res = 0;

            int i = start;
            while (i < stop) {
                while (i < stop && s.charAt(i) == split) {
                    i++;
                }
                if (i >= stop) break;
                // 分割的开始位置
                start = i;
                while (i < stop && s.charAt(i) != split) {
                    i++;
                }
                // 分割结束位置
                res = Math.max(res, dfs(s, start, i, k));

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}