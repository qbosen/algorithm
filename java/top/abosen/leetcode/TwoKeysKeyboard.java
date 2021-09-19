package top.abosen.leetcode;

//650 只有两个键的键盘
public class TwoKeysKeyboard {
    public static void main(String[] args) {
        Solution solution = new TwoKeysKeyboard().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSteps(int n) {
            int ans = 0;
            for (int i = 2; i * i <= n; ++i) {
                while (n % i == 0) {
                    n /= i;
                    ans += i;
                }
            }
            if (n > 1) {
                ans += n;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}