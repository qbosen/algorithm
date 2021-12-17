package top.abosen.leetcode;

//[1518] 换酒问题
/* 9,3 */
public class WaterBottles {
    public static void main(String[] args) {
        Solution solution = new WaterBottles().new Solution();
        System.out.println(solution.numWaterBottles(9, 3) + "==13");
        System.out.println(solution.numWaterBottles(15, 4) + "==9");
        System.out.println(solution.numWaterBottles(5, 5) + "==6");
        System.out.println(solution.numWaterBottles(2, 3) + "==2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int res = numBottles;
            int bottle = numBottles;
            while(bottle >= numExchange){
                int news = bottle / numExchange;
                res += news;
                // 新换的酒加上未换的瓶子
                bottle = news + bottle % numExchange;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}