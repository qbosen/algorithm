package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[744] 寻找比目标字母大的最小字母
/* ["c","f","j"],"a" */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            if (target >= letters[letters.length - 1]) {
                return letters[0];
            }
            int l = 0, r = letters.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (letters[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return letters[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}