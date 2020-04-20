package leetcode.editor.cn;
// 机器人的运动范围
// 面试题13

public class JiQiRenDeYunDongFanWeiLcof {
    public static void run(Solution solution, int expect, int m, int n, int k) {
        int result = solution.movingCount(m, n, k);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        run(solution, 3, 2, 3, 1);
        run(solution, 1, 3, 1, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            int[][] dp = new int[m][n];
            int result = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                        continue;
                    }
                    if (sumOfPos(i) + sumOfPos(j) > k) continue;
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] = dp[i][j] | dp[i][j - 1];
                    }
                    if (dp[i][j] == 1) result++;
                }
            }
            return result;
        }

        private int sumOfPos(int num) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}