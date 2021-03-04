package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//354 俄罗斯套娃信封问题
/* [[5,4],[6,4],[6,7],[2,3]] */
public class RussianDollEnvelopes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes.length == 0) return 0;
            Arrays.sort(envelopes, Comparator.comparing((int[] ints) -> ints[0])
                    .thenComparing(Comparator.comparing((int[] ints) -> ints[1]).reversed()));

            // 对高度进行 lis
            int len = 1;
            int[] d = new int[envelopes.length + 1];
            d[len] = envelopes[0][1];
            for (int i = 1; i < envelopes.length; i++) {
                if (envelopes[i][1] > d[len]) {
                    d[len + 1] = envelopes[i][1];
                    len++;
                } else {
                    int l = 1, r = len;
                    while (l < r) {
                        int mid = (l + r) / 2;
                        if (d[mid] < envelopes[i][1]) {
                            l = mid + 1;
                        } else {
                            r = mid;
                        }
                    }
                    d[l] = envelopes[i][1];
                }
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}