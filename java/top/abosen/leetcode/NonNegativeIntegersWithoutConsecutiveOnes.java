package top.abosen.leetcode;

//600 不含连续1的非负整数
public class NonNegativeIntegersWithoutConsecutiveOnes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findIntegers(int n) {
            int[] dp = new int[31];
            dp[0] = dp[1] = 1;
            for (int i = 2; i < 31; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            int pre = 0, res = 0;
            // 子树规模，最多29层
            for (int i = 29; i >= 0; --i) {
                int val = 1 << i;
                // if 语句判断 当前子树是否有右子树
                if ((n & val) != 0) {
                    // 有右子树
                    n -= val;
                    res += dp[i + 1]; // 先将左子树（满二叉树）的路径加到结果中

                    // 处理右子树
                    if (pre == 1) {
                        // 上一层为 1，之后要处理的右子树根节点肯定也为 1
                        // 此时连续两个 1，不满足题意，直接退出
                        break;
                    }
                    // 标记当前根节点为 1
                    pre = 1;
                } else {
                    // 无右子树，此时不能保证左子树是否为满二叉树，所以要在下一层再继续判断
                    pre = 0;
                }

                if (i == 0) {
                    ++res;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}