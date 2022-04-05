package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[762] 二进制表示中质数个计算置位
/* 6,10 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public static void main(String[] args) {
        Solution solution = new PrimeNumberOfSetBitsInBinaryRepresentation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countPrimeSetBits(int left, int right) {
            int res = 0;
            for (int i = left; i <= right; i++) {
                int cnt = 0;
                int x = i;
                while (x != 0) {
                    cnt++;
                    x &= (x - 1);
                }
                if (cnt == 2 || cnt == 3 || cnt == 5 || cnt == 7 || cnt == 11 || cnt == 13 || cnt == 17 || cnt == 19 || cnt == 23 || cnt == 29 || cnt == 31)
                    res++;
            }

            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}