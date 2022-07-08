package leetcode.editor.cn;

//[1217] 玩筹码
/* [1,2,3] */
public class MinimumCostToMoveChipsToTheSamePosition {
    public static void main(String[] args) {
        Solution solution = new MinimumCostToMoveChipsToTheSamePosition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostToMoveChips(int[] position) {
            int odd = 0, even = 0;
            for (int pos : position) {
                if (pos % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            return Math.min(even, odd);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}