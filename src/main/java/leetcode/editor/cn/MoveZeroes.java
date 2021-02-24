package leetcode.editor.cn;

import util.IntUtil;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] ints = IntUtil.parse1DIntArray("[0,1,0,3,12]");
        solution.moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int zCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    zCount++;
                else {
                    nums[i - zCount] = nums[i];
                }
            }
            for (int i = nums.length - zCount; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}