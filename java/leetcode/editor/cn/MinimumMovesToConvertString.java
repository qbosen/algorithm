package leetcode.editor.cn;

//[2027] 转换字符串的最少操作次数
/* "XXX" */
public class MinimumMovesToConvertString {
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToConvertString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumMoves(String s) {
            int n = s.length();
            int i = 0;
            int ans = 0;
            while (i < n) {
                while (i < n && s.charAt(i) == 'O') {
                    i++;
                }
                if (i >= n) break;
                ans++;
                i += 3;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}