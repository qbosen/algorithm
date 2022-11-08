package leetcode.editor.cn;

//[1684] 统计一致字符串的数目
/* "ab",["ad","bd","aaab","baa","badab"] */
public class CountTheNumberOfConsistentStrings {
    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfConsistentStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            int res = 0, mask = 0;
            for (int i = 0; i < allowed.length(); i++) {
                char c = allowed.charAt(i);
                mask |= 1 << (c - 'a');
            }
            for (String word : words) {
                boolean valid = true;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    int bit = 1 << (c - 'a');
                    if ((bit & mask) == 0) {
                        valid = false;
                        break;
                    }
                }
                if (valid) res++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}