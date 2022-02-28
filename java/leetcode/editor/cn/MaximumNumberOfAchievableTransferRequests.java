package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[1601] 最多可达成的换楼请求数目
/* 5,[[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]] */
public class MaximumNumberOfAchievableTransferRequests {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfAchievableTransferRequests().new Solution();
        System.out.println(solution.maximumRequests(5, new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumRequests(int n, int[][] r) {
            int[] delta = new int[n];
            int res = 0, m = r.length;
            // 枚举所有请求组合
            for (int mask = 0; mask < (1 << m); mask++) {
                int bitCount = Integer.bitCount(mask);
                if (bitCount <= res) {
                    continue;
                }
                // 计算该plan的转移情况
                Arrays.fill(delta, 0);
                for (int i = 0; i < m; i++) {
                    if ((mask & (1 << i)) != 0) {
                        delta[r[i][0]]--;
                        delta[r[i][1]]++;
                    }
                }
                // check
                boolean valid = true;
                for (int i : delta) {
                    if (i != 0) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    res = bitCount;
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}