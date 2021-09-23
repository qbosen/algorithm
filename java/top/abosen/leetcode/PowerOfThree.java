package top.abosen.leetcode;

//[326] 3的幂
/* 27 */
public class PowerOfThree {
    public static void main(String[] args) {
        Solution solution = new PowerOfThree().new Solution();
        System.out.println(solution.isPowerOfThree(6561));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n <= 0) return false;
            int i = n;
            while (i != 1) {
                if (i % 3 != 0) {
                    return false;
                }
                i = i / 3;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}