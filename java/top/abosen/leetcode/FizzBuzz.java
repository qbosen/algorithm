package top.abosen.leetcode;

import java.util.ArrayList;
import java.util.List;

//[412] Fizz Buzz
/* 3 */
public class FizzBuzz {
    public static void main(String[] args) {
        Solution solution = new FizzBuzz().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fizzBuzz(int n) {
            String[] turn = new String[16];
            turn[3] = turn[6] = turn[9] = turn[12] = "Fizz";
            turn[5] = turn[10] = "Buzz";
            turn[15] = "FizzBuzz";
            List<String> res = new ArrayList<>(n);
            for (int i = 1, idx = 1; i <= n; i++) {
                String value = turn[idx];
                res.add(value == null ? String.valueOf(i) : value);

                if (idx == 15) {
                    idx = 1;
                } else {
                    idx++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}