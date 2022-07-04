package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[1200] 最小绝对差
/* [4,2,1,3] */
public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            List<List<Integer>> res = new ArrayList<>();
            int minSub = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length; i++) {
                int sub = arr[i] - arr[i - 1];
                if (sub < minSub) {
                    minSub = sub;
                    res.clear();
                }
                if (sub == minSub) {
                    res.add(List.of(arr[i - 1], arr[i]));
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}