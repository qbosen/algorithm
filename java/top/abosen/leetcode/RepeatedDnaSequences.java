package top.abosen.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//[187] 重复的DNA序列
/* "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" */
public class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
        System.out.println(solution.findRepeatedDnaSequences("AAAAAAAAAAAA"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Map<Integer, Integer> idxMap = new HashMap<>();
            List<String> res = new ArrayList<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                int code = encode(s, i);
                if (idxMap.containsKey(code)) {
                    Integer idx = idxMap.get(code);
                    if (idx >= 0) {
                        res.add(s.substring(idx, idx + 10));
                        idxMap.put(code, ~idx);
                    }
                } else {
                    idxMap.put(code, i);
                }
            }
            return res;
        }

        private int encode(String s, int start) {
            int res = 0;
            for (int i = 0; i < 10; i++) {
                char c = s.charAt(start + i);
                res = (res << 2);
                switch (c) {
                    case 'A':
                        break;
                    case 'C':
                        res |= 1;
                        break;
                    case 'G':
                        res |= 2;
                        break;
                    case 'T':
                        res |= 3;
                        break;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}