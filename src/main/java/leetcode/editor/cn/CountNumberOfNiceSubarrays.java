package leetcode.editor.cn;
// 统计「优美子数组」
// 1248
// [1,1,2,1,1] 3

import util.IntUtil;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfNiceSubarrays {
    public static void run(Solution solution, int expect, String nums, int k) {
        int[] nums_ = IntUtil.parse1DIntArray(nums);
        int k_ = k;
        int result = solution.numberOfSubarrays(nums_, k_);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new CountNumberOfNiceSubarrays().new Solution();
        run(solution, 2, "[1,1,2,1,1]", 3);
        run(solution, 0, "[2,4,6]", 1);
        run(solution, 16, "[2,2,2,1,2,2,1,2,2,2]", 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 1)
                    list.add(i);
            }

            if (list.size() < k) return 0;
            int result = 0;

            for (int i = 0; i <= list.size() - k; i++) {
                int l = i - 1 >= 0 ? list.get(i - 1) : -1;
                int r = i + k < list.size() ? list.get(i + k) : nums.length;
                result += (list.get(i) - l) * (r - list.get(i + k - 1));
            }

            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}