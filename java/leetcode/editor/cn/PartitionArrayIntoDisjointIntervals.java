package leetcode.editor.cn;

//[915] 分割数组
/* [5,0,3,8,6] */
public class PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        Solution solution = new PartitionArrayIntoDisjointIntervals().new Solution();
        System.out.println(solution.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(solution.partitionDisjoint(new int[]{1,1,1,0,6,12}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length;
            int[] min = new int[n];

            min[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                min[i] = Math.min(min[i + 1], nums[i]);
            }

            int maxL = nums[0];
            for (int i = 1; i < n; i++) {
                if (maxL <= min[i]) {
                    return i;
                }
                maxL = Math.max(maxL, nums[i]);
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}