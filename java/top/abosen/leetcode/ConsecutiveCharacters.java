package top.abosen.leetcode;

//[1446] 连续字符
/* "leetcode" */
public class ConsecutiveCharacters {
    public static void main(String[] args) {
        Solution solution = new ConsecutiveCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPower(String s) {
            int res = 0;
            int cur = 0;
            char prev = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != prev) {
                    cur = 1;
                } else {
                    cur++;
                }
                prev = s.charAt(i);
                res = Math.max(res, cur);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}