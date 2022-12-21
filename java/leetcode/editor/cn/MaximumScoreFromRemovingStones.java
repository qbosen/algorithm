package leetcode.editor.cn;

//[1753] 移除石子的最大得分
/* 2,4,6 */
public class MaximumScoreFromRemovingStones {
    public static void main(String[] args) {
        Solution solution = new MaximumScoreFromRemovingStones().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumScore(int a, int b, int c) {
            int sum = a + b + c;
            int max = Math.max(Math.max(a,b), c);
            return Math.min(sum / 2, sum - max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}