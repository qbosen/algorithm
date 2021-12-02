package top.abosen.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//[506] 相对名次
/* [5,4,3,2,1] */
public class RelativeRanks {
    public static void main(String[] args) {
        Solution solution = new RelativeRanks().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRelativeRanks(int[] score) {
            Map<Integer, Integer> scoreIndex = new HashMap<>();
            for (int i = 0; i < score.length; i++) {
                scoreIndex.put(score[i], i);
            }
            Arrays.sort(score);
            String[] res = new String[score.length];
            for (int i = 0; i < score.length; i++) {
                int idx = score.length - i - 1;
                int originIdx = scoreIndex.get(score[idx]);
                if (i == 0) {
                    res[originIdx] = "Gold Medal";
                } else if (i == 1) {
                    res[originIdx] = "Silver Medal";
                } else if (i == 2) {
                    res[originIdx] = "Bronze Medal";
                } else {
                    res[originIdx] = String.valueOf(i + 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}