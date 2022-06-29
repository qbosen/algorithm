package leetcode.editor.cn;

import java.util.Arrays;

//[324] 摆动排序 II
/* [1,5,1,1,6,4] */
public class WiggleSortIi {
    public static void main(String[] args) {
        Solution solution = new WiggleSortIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            int[] clone = nums.clone();
            Arrays.sort(clone);
            //两个指针
            int left = (nums.length - 1) / 2, right = nums.length - 1;
            //依次放置
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    nums[i] = clone[left];
                    left--;
                } else {
                    nums[i] = clone[right];
                    right--;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}