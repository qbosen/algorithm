package top.abosen.leetcode;

//[495] 提莫攻击
/* [1,4],2 */
public class TeemoAttacking {
    public static void main(String[] args) {
        Solution solution = new TeemoAttacking().new Solution();
        System.out.println(solution.findPoisonedDuration(new int[]{1, 2, 3, 4, 5}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if (timeSeries.length == 0 || duration == 0) return 0;
            int res = 0;
            int last = timeSeries[0];
            for (int i = 1; i < timeSeries.length; i++) {
                int cur = timeSeries[i];
                if (last + duration > cur) {
                    res += cur - last;
                } else {
                    res += duration;
                }
                last = cur;
            }
            res += duration;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}