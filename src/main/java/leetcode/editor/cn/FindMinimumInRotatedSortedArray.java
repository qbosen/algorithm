package leetcode.editor.cn;

//153 寻找旋转排序数组中的最小值
/* [3,4,5,1,2] */
public class FindMinimumInRotatedSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if(nums[mid] < nums[r]){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }
            return nums[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}