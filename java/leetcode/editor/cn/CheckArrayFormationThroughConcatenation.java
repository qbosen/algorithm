package leetcode.editor.cn;

import java.util.HashMap;

//[1640] 能否连接形成数组
/* [85],[[85]] */
public class CheckArrayFormationThroughConcatenation {
    public static void main(String[] args) {
        Solution solution = new CheckArrayFormationThroughConcatenation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            var map = new HashMap<Integer, Integer>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }

            for (int[] piece : pieces) {
                if (!map.containsKey(piece[0])) {
                    return false;
                }
                int start = map.get(piece[0]);
                for (int p : piece) {
                    if (!map.containsKey(p)) {
                        return false;
                    }
                    if (map.get(p) != start++) {
                        return false;
                    }
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}