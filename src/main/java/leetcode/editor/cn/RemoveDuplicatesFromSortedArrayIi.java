package leetcode.editor.cn;

//80 删除有序数组中的重复项 II
/* [1,1,1,2,2,3] */
public class RemoveDuplicatesFromSortedArrayIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 2) return nums.length;
            int i = 0;
            int j = 0;

            while (j < nums.length) {
                int c = 1;
                while (j > 0 && j < nums.length && nums[j] == nums[j - 1]) {
                    c++;
                    if (c <= 2) {
                        nums[i++] = nums[j];
                    }
                    j++;
                }
                if (j < nums.length) {
                    nums[i++] = nums[j++];
                }
            }

            return nums.length - j + i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}