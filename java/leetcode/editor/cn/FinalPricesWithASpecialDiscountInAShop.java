package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//[1475] 商品折扣后的最终价格
/* [8,4,6,2,3] */
public class FinalPricesWithASpecialDiscountInAShop {
    public static void main(String[] args) {
        Solution solution = new FinalPricesWithASpecialDiscountInAShop().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] finalPrices(int[] prices) {
            int n = prices.length;
            int[] ans = new int[n];
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() > prices[i]) {
                    stack.pop();
                }
                ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
                stack.push(prices[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}