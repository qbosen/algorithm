package top.abosen.leetcode;

import java.util.Arrays;

//[869] 重新排序得到 2 的幂
/* 1 */
public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        Solution solution = new ReorderedPowerOf2().new Solution();
        System.out.println(solution.reorderedPowerOf2(1));
        System.out.println(solution.reorderedPowerOf2(10));
        System.out.println(solution.reorderedPowerOf2(16));
        System.out.println(solution.reorderedPowerOf2(24));
        System.out.println(solution.reorderedPowerOf2(46));
        System.out.println(solution.reorderedPowerOf2(1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] arr = new int[10];
        StringBuilder sb = new StringBuilder();

        public boolean reorderedPowerOf2(int n) {
            String s = String.valueOf(n);
            int len = s.length();
            int power = 1;
            for (int i = 0; i < len; i++) {
                power *= 10;
            }
            int high = power - 1, low = power / 10;

            String hashN = hash(n);

            for (int i = 0, num = 1; i < 31; i++, num <<= 1) {
                if (num <= high && num >= low && hashN.equals(hash(num))) {
                    return true;
                }
            }
            return false;
        }

        // 统计一个前导非0的数的十进制数字特征
        private String hash(int num) {
            Arrays.fill(arr, 0);
            sb.setLength(0);
            while (num != 0) {
                arr[num % 10]++;
                num /= 10;
            }
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(i);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}