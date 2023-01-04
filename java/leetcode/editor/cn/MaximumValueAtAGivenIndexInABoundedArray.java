package leetcode.editor.cn;

//[1802] 有界数组中指定下标处的最大值
/* 4,2,6 */
public class MaximumValueAtAGivenIndexInABoundedArray {
    public static void main(String[] args) {
        Solution solution = new MaximumValueAtAGivenIndexInABoundedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int left = 1, right = maxSum;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (sum(mid - 1, index) + sum(mid, n - index) <= maxSum) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private long sum(long x, int cnt) {
            return x >= cnt ? (x + x - cnt + 1) * cnt / 2 : (x + 1) * x / 2 + cnt - x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}