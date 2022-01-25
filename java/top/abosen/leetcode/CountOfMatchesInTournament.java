package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[1688] 比赛中的配对次数
/* 7 */
public class CountOfMatchesInTournament {
    public static void main(String[] args) {
        Solution solution = new CountOfMatchesInTournament().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfMatches(int n) {
            int res = 0;
            while (n != 1) {
                if (n % 2 == 0) {
                    n /= 2;
                    res += n;
                } else {
                    n /= 2;
                    res += n;
                    n++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}