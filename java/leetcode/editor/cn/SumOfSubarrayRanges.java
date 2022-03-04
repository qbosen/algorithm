package leetcode.editor.cn;

//[2104] 子数组范围和
/* [1,2,3] */
public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayRanges().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long subArrayRanges(int[] nums) {
            int n = nums.length;
            long res = 0;
            for (int i = 0; i < n; i++) {
                int min = nums[i], max = nums[i];
                for (int j = i + 1; j < n; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    res += max - min;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}