package leetcode.editor.cn;

import java.util.*;

//[40] 组合总和 II
/* [10,1,2,7,6,1,5],8 */
public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();
            backtrack(candidates, target, result, 0, new ArrayDeque<Integer>());
            return result;
        }

        private void backtrack(int[] candidates, int target, List<List<Integer>> result, int begin, Deque<Integer> path) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < candidates.length; i++) {
                int current = candidates[i];
                if (target < current) {
                    break;
                }

                //去重
                if (i > begin && current == candidates[i - 1]) {
                    continue;
                }
                path.addLast(current);
                backtrack(candidates, target - current, result, i + 1, path);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}