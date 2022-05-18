package leetcode.editor.cn;

//[668] 乘法表中第k小的数
/* 3,3,5 */
public class KthSmallestNumberInMultiplicationTable {
    public static void main(String[] args) {
        Solution solution = new KthSmallestNumberInMultiplicationTable().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int l = 1, r = m * n;
            while (l < r) {
                int mid = (l + r) / 2;
                // 求解小于mid的有多少个
                int count = 0;
                for (int i = 1; i <= m; i++) {
                    count += Math.min(n, mid / i);
                }
                // 二分
                if (count >= k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}