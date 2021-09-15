package top.abosen.leetcode;

//[162] 寻找峰值
/* [1,2,3,1] */
public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
        System.out.println(solution.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (nums[m] < nums[m + 1]) {
                    l = m + 1;
                } else if (m == 0 || nums[m] > nums[m - 1]) {
                    return m;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}