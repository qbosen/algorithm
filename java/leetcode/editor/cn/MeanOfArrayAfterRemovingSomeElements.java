package leetcode.editor.cn;

import java.util.Arrays;

//[1619] 删除某些元素后的数组均值
/* [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3] */
public class MeanOfArrayAfterRemovingSomeElements {
    public static void main(String[] args) {
        Solution solution = new MeanOfArrayAfterRemovingSomeElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double trimMean(int[] arr) {
            int n = arr.length;
            int d = n / 20;

            Arrays.sort(arr);
            double sum = 0;
            for (int i = d; i < n - d; i++) {
                sum += arr[i];
            }
            return sum / (n - 2 * d);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}