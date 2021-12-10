package top.abosen.leetcode;

import java.util.Arrays;

//[748] 最短补全词
/* "1s3,PSt",["step","steps","stripe","stepple"] */
public class ShortestCompletingWord {
    public static void main(String[] args) {
        Solution solution = new ShortestCompletingWord().new Solution();
        solution.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            int[] license = new int[26];
            int[] word = new int[26];

            for (int i = 0; i < licensePlate.length(); i++) {
                char c = licensePlate.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    license[c - 'a']++;
                } else if (c >= 'A' && c <= 'Z') {
                    license[c - 'A']++;
                }
            }

            String res = null;
            int len = Integer.MAX_VALUE;
            for (String s : words) {
                Arrays.fill(word, 0);
                boolean condition = true;
                for (int j = 0; j < s.length(); j++) {
                    word[s.charAt(j) - 'a']++;
                }
                for (int j = 0; j < 26; j++) {
                    if (word[j] < license[j]) {
                        condition = false;
                        break;
                    }
                }
                if (condition && s.length() < len) {
                    res = s;
                    len = res.length();
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}