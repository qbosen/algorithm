package leetcode.editor.cn;

//[901] 股票价格跨度
/* ["StockSpanner","next","next","next","next","next","next","next"],[[],[100],[80],[60],[70],[60],[75],[85]] */
public class OnlineStockSpan {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {
        // price, lastBigIdx
        int[][] memo;
        int ptr;

        public StockSpanner() {
            memo = new int[10001][2];
            memo[0] = new int[]{Integer.MAX_VALUE, 0};
            ptr = 1;
        }

        public int next(int price) {
            int count = 1;
            int last = ptr;
            if (price >= memo[ptr - 1][0]) {
                last = memo[ptr - 1][1];
                while (last >= 0 && price >= memo[last][0]) {
                    last--;
                }
                count = ptr - last;
            }
            memo[ptr] = new int[]{price, last};
            ptr++;
            return count;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

}