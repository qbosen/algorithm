package leetcode.editor.cn;
// 鸡蛋掉落
// 887
// 1 2

public class SuperEggDrop {
    public static void run(Solution solution, int expect, int K, int N) {
        int result = solution.superEggDrop(K, N);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new SuperEggDrop().new Solution();
        run(solution, 2, 1, 2);
        run(solution, 3, 2, 6);
        run(solution, 4, 3, 14);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int superEggDrop(int K, int N) {
            if (N == 1) return 1;
            int[][] dp = new int[N + 1][K + 1];
            for (int i = 1; i <= K; i++) {
                dp[1][i] = 1;
            }

            int ans = -1;
            for (int i = 2; i <= N; ++i) {
                for (int j = 1; j <= K; ++j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
                }
                if (dp[i][K] >= N) {
                    ans = i;
                    break;
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}