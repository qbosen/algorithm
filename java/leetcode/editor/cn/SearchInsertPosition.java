package leetcode.editor.cn;

//[35] 搜索插入位置
/* [1,3,5,6],5 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            if (nums[r] < target) {
                return r + 1;
            }
            while (l < r) {
                int m = (r - l) / 2 + l;
                if (nums[m] < target) {
                    l = m + 1;
                } else if (nums[m] > target) {
                    r = m;
                } else {
                    return m;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}