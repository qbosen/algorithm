package leetcode.editor.cn;

import java.util.HashMap;

//[面试题 01.02] 判定是否互为字符重排
/* "abc","bca" */
public class CheckPermutationLcci {
    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            var map = new HashMap<Character, Integer>();
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                map.compute(c, (k, v) -> v == null ? 1 : v + 1);
            }
            for (int i = 0; i < s2.length(); i++) {
                char c = s2.charAt(i);
                if (null == map.compute(c, (k, v) -> v == null || v == 0 ? null : v - 1)) {
                    return false;
                }
            }
            return map.values().stream().allMatch(it -> it == 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}