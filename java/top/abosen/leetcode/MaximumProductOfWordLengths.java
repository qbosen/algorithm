package top.abosen.leetcode;

import java.util.HashMap;
import java.util.Map;

//[318] 最大单词长度乘积
/* ["abcw","baz","foo","bar","xtfn","abcdef"] */
public class MaximumProductOfWordLengths {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfWordLengths().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            // encode: length
            Map<Integer, Integer> map = new HashMap<>();
            for (String word : words) {
                int encode = 0;
                for (int i = 0; i < word.length(); i++) {
                    encode |= 1 << (word.charAt(i) - 'a');
                }
                map.compute(encode, (k, v) -> v == null || v < word.length() ? word.length() : v);

            }
            int res = 0;

            Integer[] keys = map.keySet().toArray(new Integer[0]);
            for (int i = 0; i < keys.length; i++) {
                for (int j = i + 1; j < keys.length; j++) {
                    if ((keys[i] & keys[j]) == 0) {
                        res = Math.max(res, map.get(keys[i]) * map.get(keys[j]));
                    }
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}