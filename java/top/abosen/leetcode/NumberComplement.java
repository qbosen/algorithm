package top.abosen.leetcode;

//[476] 数字的补数
/* 5 */
public class NumberComplement {
    public static void main(String[] args) {
        Solution solution = new NumberComplement().new Solution();
        System.out.println(solution.findComplement(0));
        System.out.println(solution.findComplement(1));
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(Integer.MAX_VALUE - 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findComplement(int num) {
            int highbit = 0;
            for (int i = 1; i <= 30; ++i) {
                if (num >= 1 << i) {
                    highbit = i;
                } else {
                    break;
                }
            }
            int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
            return num ^ mask;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}