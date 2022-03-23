package leetcode.editor.cn;

import java.util.*;

//[440] 字典序的第K小数字
/* 13,2 */
public class KThSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        Solution solution = new KThSmallestInLexicographicalOrder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int n, int k) {
            int x = 1;
            while (k != 1) {
                int cnt = getCnt(x, n);
                if (cnt < k) {
                    x++;
                    k -= cnt;
                } else {
                    x *= 10;
                    k--;
                }
            }
            return x;
        }

        static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};

        static int len(int n) {
            int index = Arrays.binarySearch(sizeTable, n);
            return index >= 0 ? index + 1 : -index;
        }

        private int getCnt(int x, int limit) {
            int p = len(x), q = len(limit);
            // u是limit前p个数
            int pow = 1, res = 0;
            for (int i = 0; i < q - p; i++) {
                // 长度小于q的结果
                res += pow;
                pow = pow * 10;
            }
            int u = limit / pow;
            if (x == u) {
                res += limit - x * pow + 1;
            } else if (x < u) {
                res += pow;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}