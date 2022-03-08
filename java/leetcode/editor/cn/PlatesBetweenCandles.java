package leetcode.editor.cn;

import java.util.Arrays;

//[2055] 蜡烛之间的盘子
/* "**|**|***|",[[2,5],[5,9]] */
public class PlatesBetweenCandles {
    public static void main(String[] args) {
        Solution solution = new PlatesBetweenCandles().new Solution();
        System.out.println(Arrays.toString(solution.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}})));
        System.out.println(Arrays.toString(solution.platesBetweenCandles("***", new int[][]{{0, 1}, {1, 2}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int[] res = new int[queries.length];
            int n = s.length();
            char[] chars = s.toCharArray();
            int[] sum = new int[n + 1];
            // 维护每个元素左右最近的蜡烛
            int[] lc = new int[n], rc = new int[n];

            for (int i = 0, j = n - 1, ll = -1, rr = -1; i < n; i++, j--) {
                if (chars[i] == '|') ll = i;
                if (chars[j] == '|') rr = j;
                lc[i] = ll;
                rc[j] = rr;
                sum[i + 1] = sum[i] + (chars[i] == '*' ? 1 : 0);
            }

            for (int k = 0; k < queries.length; k++) {
                int i = queries[k][0], j = queries[k][1];
                int a = rc[i], b = lc[j];
                if (a != -1 && b >= a) {
                    res[k] = sum[b + 1] - sum[a];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}