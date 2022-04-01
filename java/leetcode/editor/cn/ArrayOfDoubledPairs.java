package leetcode.editor.cn;

import java.util.*;

//[954] 二倍数对数组
/* [3,1,3,6] */
public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        Solution solution = new ArrayOfDoubledPairs().new Solution();
        System.out.println(solution.canReorderDoubled(new int[]{2, 1, 2, 1, 1, 1, 2, 2}));  //true
        System.out.println(solution.canReorderDoubled(new int[]{4, -2, 2, -4}));  //true
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : arr) {
                map.compute(i, (k, v) -> v == null ? 1 : v + 1);
            }
            // i*2 == i 的单独处理
            if (map.getOrDefault(0, 0) % 2 != 0) {
                return false;
            }

            // 按绝对值排序
            List<Integer> list = new ArrayList<>(arr.length);
            list.addAll(map.keySet());
            list.sort(Comparator.comparing(Math::abs));

            for (Integer i : list) {
                int count = map.get(i);
                if (count == 0) {
                    continue;
                }
                if (map.compute(2 * i, (k, v) -> (v == null ? 0 : v) - count) < 0) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}