package top.abosen.leetcode;

//[400] 第 N 位数字
/* 3 */
public class NthDigit {
    public static void main(String[] args) {
        Solution solution = new NthDigit().new Solution();
        for (int i = 0; i < 100; i++) {
            System.out.println(solution.findNthDigit(i));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            // 二分法求出来 n 是几位数
            int l = 1, r = 10;
            while (l < r) {
                int m = (l + r) / 2;
                long cm = calPos(m);
                if (cm >= n) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            // n 在 l位数中的 字符位置
            int pos = n - (int) calPos(l - 1) - 1;
            // n在l位数字中的 数字位置
            int indexInGroup = pos / l;
            // n的字符位置 在该数字中的 位置
            int indexInNum = pos % l;

            int base = 1;
            for (int i = 0; i < l - 1; i++) {
                base *= 10;
            }
            // 求出具体数字
            int num = base + indexInGroup;
            // 找出该数字 从左起的 第 indexInNum 位数字
            for (int i = 0; i < l - indexInNum - 1; i++) {
                num /= 10;
            }
            return num % 10;
        }

        public long calPos(int p) {
            long base = 1;
            long c = 0;
            for (int i = 0; i < p; i++, base *= 10) {
                c += base;
            }
            return p * base - c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}