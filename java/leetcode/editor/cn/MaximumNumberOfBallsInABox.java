package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//[1742] 盒子中小球的最大数量
/* 1,10 */
public class MaximumNumberOfBallsInABox {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfBallsInABox().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            Map<Integer, Integer> counter = new HashMap<>();
            int maxCount = 0;

            for (int i = lowLimit; i <= highLimit ; i++) {
                Integer compute = counter.compute(cal(i), (k, v) -> v == null ? 1 : v + 1);
                maxCount = Math.max(maxCount, compute);
            }
            return maxCount;
        }

        int cal(int n) {
            int res = 0;
            while (n != 0) {
                res += n % 10;
                n /= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}