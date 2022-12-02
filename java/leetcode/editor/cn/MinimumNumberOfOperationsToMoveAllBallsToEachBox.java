package leetcode.editor.cn;

//[1769] 移动所有球到每个盒子所需的最小操作数
/* "110" */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfOperationsToMoveAllBallsToEachBox().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] minOperations(String boxes) {
            int left = boxes.charAt(0) - '0', right = 0, operations = 0;
            int n = boxes.length();
            for (int i = 1; i < n; i++) {
                if (boxes.charAt(i) == '1') {
                    right++;
                    operations += i;
                }
            }
            int[] res = new int[n];
            res[0] = operations;
            for (int i = 1; i < n; i++) {
                operations += left - right;
                if (boxes.charAt(i) == '1') {
                    left++;
                    right--;
                }
                res[i] = operations;
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}