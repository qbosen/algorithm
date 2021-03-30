package leetcode.editor.cn;

//74 搜索二维矩阵
/* [[1,3,5,7],[10,11,16,20],[23,30,34,60]],3 */
public class SearchA2dMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int top = -1;
            int bottom = m - 1;
            while (top < bottom) {
                int mid = (top + bottom + 1) / 2;
                if (matrix[mid][0] > target) {
                    bottom = mid - 1;
                } else {
                    top = mid;
                }
            }
            if (top < 0) return false;

            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[top][mid] < target) {
                    left = mid + 1;
                } else if (matrix[top][mid] > target) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}