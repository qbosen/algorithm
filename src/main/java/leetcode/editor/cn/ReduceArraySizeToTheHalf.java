package leetcode.editor.cn;

import util.IntArrayUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ReduceArraySizeToTheHalf {
    public static void main(String[] args) {
        Solution solution = new ReduceArraySizeToTheHalf().new Solution();
        int[] ints = IntArrayUtil.parse1DIntArray("[3,3,3,3,5,5,5,2,2,7]");
        System.out.println(solution.minSetSize(ints));
        ints = IntArrayUtil.parse1DIntArray("[7,7,7,7,7,7]");
        System.out.println(solution.minSetSize(ints));
        ints = IntArrayUtil.parse1DIntArray("[1,9]");
        System.out.println(solution.minSetSize(ints));
        ints = IntArrayUtil.parse1DIntArray("[1000,1000,3,7]");
        System.out.println(solution.minSetSize(ints));
        ints = IntArrayUtil.parse1DIntArray("[1,2,3,4,5,6,7,8,9,10]");
        System.out.println(solution.minSetSize(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSetSize(int[] arr) {
            HashMap<Integer, Integer> counter = new HashMap<>();
            for (int i : arr) {
                counter.compute(i, (k, v) -> v == null ? 1 : v + 1);
            }
            ArrayList<Integer> list = new ArrayList<>(counter.values());
            list.sort(Comparator.reverseOrder());

            int half = (arr.length + 1) / 2;
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
                if (sum >= half) {
                    return i + 1;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}