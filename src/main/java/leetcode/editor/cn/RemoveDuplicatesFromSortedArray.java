package leetcode.editor.cn;

//26 删除有序数组中的重复项
/* [1,1,2] */
public class RemoveDuplicatesFromSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }

            int slow = 1;
            int fast = 1;
            while (fast < nums.length) {
                while (fast < nums.length && nums[fast] == nums[fast - 1]) {
                    fast++;
                }
                if (fast < nums.length) {
                    nums[slow] = nums[fast];
                    slow++;
                    fast++;
                }
            }

            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}