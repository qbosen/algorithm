package top.abosen.leetcode;

//[859] 亲密字符串
/* "ab","ba" */
public class BuddyStrings {
    public static void main(String[] args) {
        Solution solution = new BuddyStrings().new Solution();
        System.out.println(solution.buddyStrings("aa", "aa"));
        System.out.println(solution.buddyStrings("ab", "ab"));
        System.out.println(solution.buddyStrings("ab", "ba"));
        System.out.println(solution.buddyStrings("abac", "abad"));
        System.out.println(solution.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //一种省空间但丑陋的方法
        public boolean buddyStrings(String s, String goal) {
            if (s.length() != goal.length()) return false;
            char diffA = 0, diffB = 0;
            int time = 0;
            for (int i = 0; i < s.length(); i++) {
                char p = s.charAt(i);
                char q = goal.charAt(i);
                if (p != q) {
                    if (time == 0) {
                        diffA = p;
                        diffB = q;
                    } else if (time == 1) {
                        if (p != diffB || q != diffA) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    time++;
                }
            }
            if (time == 0) {
                if (s.length() > 26) return true;
                boolean[] dup = new boolean[26];
                for (int i = 0; i < s.length(); i++) {
                    int p = s.charAt(i) - 'a';
                    if (dup[p]) return true;
                    dup[p] = true;
                }
                return false;
            }
            return time == 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}