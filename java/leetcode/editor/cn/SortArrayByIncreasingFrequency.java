package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//[1636] 按照频率将数组升序排序
/* [1,1,2,2,2,3] */
public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        Solution solution = new SortArrayByIncreasingFrequency().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] frequencySort(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<int[]> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new int[]{key, map.get(key)});
            }
            list.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
            int[] ans = new int[n];
            int idx = 0;
            for (int[] info : list) {
                while (info[1]-- > 0) ans[idx++] = info[0];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}