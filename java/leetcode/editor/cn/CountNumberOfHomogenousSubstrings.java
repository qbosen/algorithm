package leetcode.editor.cn;

//[1759] 统计同构子字符串的数目
/* "abbcccaa" */
public class CountNumberOfHomogenousSubstrings {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfHomogenousSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countHomogenous(String s) {
            int MOD = 1000_000_007;
            long value = 0;
            int n = s.length();

            char prev = 0;
            int i = 0;
            while (i < n) {
                int start = i;
                do {
                    prev = s.charAt(i);
                    i++;
                }
                while (i < n && s.charAt(i) == prev);
                value = (value + cal(i - start)) % MOD;
            }
            return (int) (value % MOD);
        }

        long cal(int n) {
            return ((n + 1L) * n) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}