package leetcode.editor.cn;

//[1470] 重新排列数组
/* [2,5,1,3,4,7],3 */
public class ShuffleTheArray {
    public static void main(String[] args) {
        Solution solution = new ShuffleTheArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] res = new int[n * 2];
            for (int i = 0; i < n; i++) {
                res[2 * i] = nums[i];
                res[2 * i + 1] = nums[n + i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}