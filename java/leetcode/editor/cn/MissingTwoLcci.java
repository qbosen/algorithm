package leetcode.editor.cn;

//[面试题 17.19] 消失的两个数字
/* [1] */
public class MissingTwoLcci {
    public static void main(String[] args) {
        Solution solution = new MissingTwoLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingTwo(int[] nums) {
            int n = nums.length + 2;
            int twoSum = (1 + n) * n / 2;
            for (int num : nums) {
                twoSum -= num;
            }
            int half = twoSum / 2;
            int halfSum = (1 + half) * half / 2;
            for (int num : nums) {
                if (num <= half) halfSum -= num;
            }

            return new int[]{halfSum, twoSum - halfSum};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}