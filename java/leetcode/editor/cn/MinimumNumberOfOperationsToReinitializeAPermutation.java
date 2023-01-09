package leetcode.editor.cn;

import java.util.Arrays;

//[1806] 还原排列的最少操作步数
/* 2 */
public class MinimumNumberOfOperationsToReinitializeAPermutation {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfOperationsToReinitializeAPermutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reinitializePermutation(int n) {
            int[] ints = new int[n];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = i;
            }
            int[] copy = Arrays.copyOf(ints, n);
            int res = 0;
            do {
                int[] next = new int[n];
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        next[i] = copy[i / 2];
                    } else {
                        next[i] = copy[n / 2 + (i - 1) / 2];
                    }
                }
                copy = next;
                res++;
            } while (!Arrays.equals(copy, ints));

            return Math.max(res, 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}