package leetcode.editor.cn;

//[1790] 仅执行一次字符串交换能否使两个字符串相等
/* "bank","kanb" */
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        Solution solution = new CheckIfOneStringSwapCanMakeStringsEqual().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.length() != s2.length()) return false;

            int[] map = new int[26];
            int diff = 0;
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) diff++;
                map[c1 - 'a']++;
                map[c2 - 'a']--;
            }
            for (int i : map) {
                if (i != 0) {
                    return false;
                }
            }

            return diff <= 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}