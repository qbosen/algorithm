package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[728] 自除数
/* 1,22 */
public class SelfDividingNumbers {
    public static void main(String[] args) {
        Solution solution = new SelfDividingNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> res = new ArrayList<>();
            for (int n = left; n <= right; n++) {
                int cur = n;
                boolean valid = true;
                while (cur != 0) {
                    int i = cur % 10;
                    if (i == 0 || n % i != 0) {
                        valid = false;
                        break;
                    }
                    cur /= 10;
                }
                if (valid) {
                    res.add(n);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}