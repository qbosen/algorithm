package leetcode.editor.cn;

import util.IntArrayUtil;

// 41
// 缺失的第一个正数
public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        int[] ints = IntArrayUtil.parse1DIntArray("[1,2,0]");
        System.out.println(solution.firstMissingPositive(ints) + "=3");
        ints = IntArrayUtil.parse1DIntArray("[3,4,-1,1]");
        System.out.println(solution.firstMissingPositive(ints) + "=2");
        ints = IntArrayUtil.parse1DIntArray("[7,8,9,11,12]");
        System.out.println(solution.firstMissingPositive(ints) + "=1");
        ints = IntArrayUtil.parse1DIntArray("[1]");
        System.out.println(solution.firstMissingPositive(ints) + "=2");
        ints = IntArrayUtil.parse1DIntArray("[1,2,3]");
        System.out.println(solution.firstMissingPositive(ints) + "=4");
        ints = IntArrayUtil.parse1DIntArray("[1,1000]");
        System.out.println(solution.firstMissingPositive(ints) + "=2");
        ints = IntArrayUtil.parse1DIntArray("[2,1,1000]");
        System.out.println(solution.firstMissingPositive(ints) + "=3");
        ints = IntArrayUtil.parse1DIntArray("[1,0,3,3,0,2]");
        System.out.println(solution.firstMissingPositive(ints) + "=4");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) nums[i] = 0;
            }
            for (int i = 0; i < nums.length; i++) {
                dealIdx(nums, nums[i]);
            }
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] != -1)) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

        private void dealIdx(int[] nums, int value) {
            if (value > 0 && value <= nums.length) {
                int nv = nums[value - 1];
                nums[value - 1] = -1;
                dealIdx(nums, nv);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}