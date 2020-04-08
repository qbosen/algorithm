package leetcode.editor.cn;
// 904
// 水果成篮

import util.IntArrayUtil;

import java.util.HashMap;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets().new Solution();
        int[] ints = IntArrayUtil.parse1DIntArray("[3,3,3,1,2,1,1,2,3,3,4]");
        System.out.println(solution.totalFruit(ints) + "=5");
        ints = IntArrayUtil.parse1DIntArray("[1,2,3,2,2]");
        System.out.println(solution.totalFruit(ints) + "=4");
        ints = IntArrayUtil.parse1DIntArray("[0,1,2,2]");
        System.out.println(solution.totalFruit(ints) + "=3");
        ints = IntArrayUtil.parse1DIntArray("[1,2,1]");
        System.out.println(solution.totalFruit(ints) + "=3");
        ints = IntArrayUtil.parse1DIntArray("[1,0,1,4,1,4,1,2,3]");
        System.out.println(solution.totalFruit(ints) + "=5");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] tree) {
            int ans = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0, i = 0; j < tree.length; ++j) {
                map.compute(tree[j], (k, v) -> v == null ? 1 : v + 1);
                while (map.size() >= 3) {
                    map.compute(tree[i], (k, v) -> v == 1 ? null : v - 1);
                    i++;
                }

                ans = Math.max(ans, j - i + 1);
            }

            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}