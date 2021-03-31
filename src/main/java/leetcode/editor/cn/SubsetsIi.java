package leetcode.editor.cn;

import java.util.*;

//90 子集 II
/* [1,2,2] */
public class SubsetsIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            dfs(false, 0, nums);
            return result;
        }

        private void dfs(boolean choosePre, int cur, int[] nums) {
            if (cur == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }
            dfs(false, cur + 1, nums);
            // 当前元素与前一个相同，且前一个没被pick（相同数字的情况下 只有前一个被pick，后一个才有选择pick的权利）
            if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
                return;
            }
            list.add(nums[cur]);
            dfs(true, cur + 1, nums);
            list.remove(list.size() - 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}