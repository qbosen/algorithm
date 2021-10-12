package top.abosen.leetcode;

import java.util.*;
import top.abosen.leetcode.struct.*;

//[29] 两数相除
/* 10,3 */
public class DivideTwoIntegers{
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int INF = Integer.MAX_VALUE;
    public int divide(int _a, int _b) {
        long a = _a, b = _b;
        boolean flag = false;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) flag = true;
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        long l = 0, r = a;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mul(mid, b) <= a) l = mid;
            else r = mid - 1;
        }
        r = flag ? -r : r;
        if (r > INF || r < -INF - 1) return INF;
        return (int)r;
    }
    long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) ans += a;
            k >>= 1;
            a += a;
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}