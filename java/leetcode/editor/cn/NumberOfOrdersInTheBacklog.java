package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//[1801] 积压订单中的订单总数
/* [[10,5,0],[15,2,1],[25,1,1],[30,4,0]] */
public class NumberOfOrdersInTheBacklog {
    public static void main(String[] args) {
        Solution solution = new NumberOfOrdersInTheBacklog().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            int mod = 1000_000_007;
            PriorityQueue<int[]> buyOrders = new PriorityQueue<>(Comparator.comparing(it -> it[0], Comparator.reverseOrder()));
            PriorityQueue<int[]> sellOrders = new PriorityQueue<>(Comparator.comparing(it -> it[0]));
            for (int[] order : orders) {
                int price = order[0];
                int amount = order[1];
                int type = order[2];

                trade(price, amount, buyOrders, sellOrders, type == 0);
            }

            long total = buyOrders.stream().mapToLong(it -> it[1]).sum()
                    + sellOrders.stream().mapToLong(it -> it[1]).sum();
            return (int) (total % mod);
        }

        private void trade(int price, int amount, PriorityQueue<int[]> buyOrders, PriorityQueue<int[]> sellOrders, boolean buy) {
            PriorityQueue<int[]> in = buy ? buyOrders : sellOrders;
            PriorityQueue<int[]> out = buy ? sellOrders : buyOrders;

            while (amount > 0 && !out.isEmpty() && (buy ? out.peek()[0] <= price : out.peek()[0] >= price)) {
                int[] poll = out.poll();
                int tradeAmount = Math.min(poll[1], amount);
                amount -= tradeAmount;
                poll[1] -= tradeAmount;
                if (poll[1] > 0) {
                    out.offer(poll);
                }
            }
            if (amount > 0) {
                in.offer(new int[]{price, amount});
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}