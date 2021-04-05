package leetcode.editor.cn;

// 88 合并两个有序数组
/* [1,2,3,0,0,0],3,[2,5,6],3 */

public class MergeSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1, p2 = n - 1;
            int tail = m + n - 1;
            int cur;
            while (p1 >= 0 || p2 >= 0) {
                if (p1 == -1) {
                    cur = nums2[p2--];
                } else if (p2 == -1) {
                    cur = nums1[p1--];
                } else if (nums1[p1] > nums2[p2]) {
                    cur = nums1[p1--];
                } else {
                    cur = nums2[p2--];
                }
                nums1[tail--] = cur;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}