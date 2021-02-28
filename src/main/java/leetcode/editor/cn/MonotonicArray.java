package leetcode.editor.cn;

//896 单调数列
/* [1,2,2,3] */
public class MonotonicArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMonotonic(int[] A) {
            if (A.length <= 1) return true;
            int desc = 0;
            for (int i = 0; i < A.length - 1; i++) {
                int compare = Integer.compare(A[i], A[i + 1]);
                if (compare != 0) {
                    if (desc == 0) desc = compare;
                    else if (desc != compare) return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}