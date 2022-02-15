package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[540] 有序数组中的单一元素
/* [1,1,2,3,3,4,4,8,8] */
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(solution.singleNonDuplicate(new int[]{1, 3, 3, 7, 7, 11, 11}));
        System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 11, 11, 100}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int n = nums.length;
            int l = 0, r = n - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if ((m == 0 || nums[m] != nums[m - 1]) && (m == n - 1 || nums[m] != nums[m + 1])) {
                    return nums[m];
                }
                if (m > 0 && nums[m] == nums[m - 1]) {
                    // m 是元素第一次出现的位置
                    m--;
                }
                if (m % 2 == 0) {
                    l = m + 2;
                } else {
                    r = m - 1;
                }
            }
            return nums[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}