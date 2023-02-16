package leetcode.editor.cn;

//[2341] 数组能形成多少数对
/* [1,3,2,1,3,2,2] */
public class MaximumNumberOfPairsInArray {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfPairsInArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numberOfPairs(int[] nums) {
            int[] count = new int[101];
            for (int num : nums) {
                count[num]++;
            }
            int[] res = new int[2];
            for (int c : count) {
                res[0] += c / 2;
                res[1] += c % 2;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}