package top.abosen.leetcode;

//[686] 重复叠加字符串匹配
/* "abcd","cdabcdab" */
public class RepeatedStringMatch {
    public static void main(String[] args) {
        Solution solution = new RepeatedStringMatch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int repeatedStringMatch(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int ans = 0;
            while (sb.length() < b.length() && ++ans > 0) sb.append(a);
            sb.append(a);
            int idx = sb.indexOf(b);
            if (idx == -1) return -1;
            return idx + b.length() > a.length() * ans ? ans + 1 : ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}