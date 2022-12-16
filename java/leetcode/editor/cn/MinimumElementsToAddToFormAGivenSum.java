package leetcode.editor.cn;

//[1785] 构成特定和需要添加的最少元素
/* [1,-1,1],3,-4 */
public class MinimumElementsToAddToFormAGivenSum {
    public static void main(String[] args) {
        Solution solution = new MinimumElementsToAddToFormAGivenSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            long target = Math.abs(goal - sum);
            return (int) ((target % limit == 0 ? 0 : 1) + (target / limit));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}