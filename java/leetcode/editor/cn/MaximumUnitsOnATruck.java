package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//[1710] 卡车上的最大单元数
/* [[1,3],[2,2],[3,1]],4 */
public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        Solution solution = new MaximumUnitsOnATruck().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, Comparator.<int[], Integer>comparing(ints -> ints[1]).reversed());
            int res = 0;
            for (int[] box : boxTypes) {
                int count = Math.min(truckSize, box[0]);
                res += count * box[1];
                truckSize -= count;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}