package top.abosen.leetcode;

//[335] 路径交叉
/* [2,1,1,2] */
public class SelfCrossing {
    public static void main(String[] args) {
        Solution solution = new SelfCrossing().new Solution();
        System.out.println(solution.isSelfCrossing(new int[]{2, 1, 1, 2}));
        System.out.println(solution.isSelfCrossing(new int[]{1, 2, 3, 4}));
        System.out.println(solution.isSelfCrossing(new int[]{1, 1, 1, 1}));
        System.out.println(solution.isSelfCrossing(new int[]{1, 1, 2, 1, 1}));
        System.out.println(solution.isSelfCrossing(new int[]{1, 1, 2, 1, 2}));
        System.out.println(solution.isSelfCrossing(new int[]{1, 1, 2, 2, 1, 1}));
        System.out.println(solution.isSelfCrossing(new int[]{1, 1, 3, 2, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSelfCrossing(int[] d) {
            if (d.length < 4) return false;
            for (int i = 3; i < d.length; i++) {
                if (d[i] >= d[i - 2] && d[i - 1] <= d[i - 3]) {
                    return true;
                }
                if (i >= 4 && d[i] + d[i - 4] >= d[i - 2] && d[i - 1] == d[i - 3]) {
                    return true;
                }
                if (i >= 5 && d[i] + d[i - 4] >= d[i - 2] && d[i - 1] <= d[i - 3] && d[i - 2] > d[i - 4] && d[i - 3] > d[i - 5] && d[i - 1] + d[i - 5] >= d[i - 3]) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}