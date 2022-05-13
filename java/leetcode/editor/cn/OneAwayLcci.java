package leetcode.editor.cn;

//[面试题 01.05] 一次编辑
/* "horse","ros" */
public class OneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
        solution.oneEditAway("", "a");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String a, String b) {
            int n = a.length(), m = b.length();
            if (Math.abs(n - m) > 1) return false;
            if (n > m) return oneEditAway(b, a);
            int i = 0, j = 0, cnt = 0;
            while (i < n && j < m && cnt <= 1) {
                char c1 = a.charAt(i), c2 = b.charAt(j);
                if (c1 == c2) {
                    i++;
                    j++;
                } else {
                    if (n == m) {
                        i++;
                        j++;
                        cnt++;
                    } else {
                        j++;
                        cnt++;
                    }
                }
            }
            return cnt <= 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}