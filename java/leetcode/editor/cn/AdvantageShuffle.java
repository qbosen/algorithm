package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//[870] 优势洗牌
/* [2,7,11,15],[1,10,4,11] */
public class AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new AdvantageShuffle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;

            Integer[] order1 = new Integer[n];
            Integer[] order2 = new Integer[n];
            for (int i = 0; i < n; i++) {
                order1[i] = i;
                order2[i] = i;
            }

            Arrays.sort(order1, Comparator.comparing(i -> nums1[i]));
            Arrays.sort(order2, Comparator.comparing(i -> nums2[i]));

            int[] res = new int[n];
            int l = 0, r = n - 1;
            for (int i = 0; i < n; i++) {
                if(nums1[order1[i]] > nums2[order2[l]]){
                    res[order2[l]] = nums1[order1[i]];
                    l++;
                }else{
                    res[order2[r]] = nums1[order1[i]];
                    r--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}