package leetcode.editor.cn;

//[2287] 重排字符形成目标字符串
/* "ilovecodingonleetcode","code" */
public class RearrangeCharactersToMakeTargetString {
    public static void main(String[] args) {
        Solution solution = new RearrangeCharactersToMakeTargetString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rearrangeCharacters(String s, String target) {
            int[] pattern = new int[26];
            for (int i = 0; i < target.length(); i++) {
                pattern[target.charAt(i) - 'a']++;
            }

            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (pattern[i] == 0) continue;

                res = Math.min(res, counter[i] / pattern[i]);
                if (res == 0) break;

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}