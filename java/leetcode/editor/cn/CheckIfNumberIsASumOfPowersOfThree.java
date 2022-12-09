package leetcode.editor.cn;

//[1780] 判断一个数字是否可以表示成三的幂的和
/* 12 */
public class CheckIfNumberIsASumOfPowersOfThree {
    public static void main(String[] args) {
        Solution solution = new CheckIfNumberIsASumOfPowersOfThree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPowersOfThree(int n) {
            while (n != 0) {
                int r = n % 3;
                if (r == 2) return false;
                n /= 3;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}