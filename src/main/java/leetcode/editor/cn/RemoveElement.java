package leetcode.editor.cn;

// 27 移除元素
/* [3,2,2,3],3 */

public class RemoveElement {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            if(nums.length ==0) return 0;
            int i = 0;
            int j = 0;
            while (j < nums.length) {
                if(nums[j] == val){
                    j++;
                }else{
                    nums[i++] = nums[j++];
                }
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}