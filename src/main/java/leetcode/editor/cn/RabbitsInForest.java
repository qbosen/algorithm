package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//781 森林中的兔子
/* [1,0,1,0,0] */
public class RabbitsInForest {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            for (int answer : answers) {
                map.compute(answer + 1, (k, v) -> v == null ? 1 : v + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer k = entry.getKey();
                Integer v = entry.getValue();
                if (v % k == 0) {
                    res += v;
                } else {
                    res += (v / k + 1) * k;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}