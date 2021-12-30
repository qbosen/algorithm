package top.abosen.leetcode;

import java.util.Map;
import java.util.TreeMap;

//[846] 一手顺子
/* [1,2,3,6,2,3,4,7,8],3 */
public class HandOfStraights {
    public static void main(String[] args) {
        Solution solution = new HandOfStraights().new Solution();
        solution.isNStraightHand(new int[]{8, 10, 13}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            if (hand.length % groupSize != 0) {
                return false;
            }
            // 按照牌的大小 自然排序
            TreeMap<Integer, Integer> counter = new TreeMap<>();
            for (int i : hand) {
                counter.compute(i, (k, v) -> v == null ? 1 : v + 1);
            }

            while (!counter.isEmpty()) {
                Map.Entry<Integer, Integer> min = counter.firstEntry();
                int k = min.getKey(), v = min.getValue();
                for (int i = 0; i < groupSize; i++) {
                    int key = k + i;
                    Integer value = counter.get(key);
                    if (value == null || value < v) {
                        return false;
                    } else if (value > v) {
                        counter.put(key, value - v);
                    } else {
                        counter.remove(key);
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}