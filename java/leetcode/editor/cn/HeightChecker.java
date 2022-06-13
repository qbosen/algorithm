package leetcode.editor.cn;

import java.util.Arrays;

//[1051] 高度检查器
/* [1,1,4,2,1,3] */
public class HeightChecker {
    public static void main(String[] args) {
        Solution solution = new HeightChecker().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int heightChecker(int[] heights) {
            int n = heights.length;
            int[] t = new int[n];
            System.arraycopy(heights, 0, t, 0, n);
            Arrays.sort(t);
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (t[i] != heights[i]) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}