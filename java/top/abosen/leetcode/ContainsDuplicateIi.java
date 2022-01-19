package top.abosen.leetcode;

import java.util.HashSet;
import java.util.Set;

//[219] 存在重复元素 II
/* [1,2,3,1],3 */
public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> last = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (i - k > 0) {
                    last.remove(nums[i - k - 1]);
                }
                int num = nums[i];
                if (last.contains(num)) {
                    return true;
                }
                last.add(num);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}