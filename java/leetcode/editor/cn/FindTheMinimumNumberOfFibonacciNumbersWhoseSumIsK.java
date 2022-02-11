package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1414] 和为 K 的最少斐波那契数字数目
/* 7 */
public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK{
    public static void main(String[] args) {
        Solution solution = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        while (b <= k) {
            int c = a + b;
            a = b; b = c;
        }
        int ans = 0;
        // 反推
        while (k != 0) {
            if (k >= b) {
                k -= b; ans++;
            }
            int c = b - a;
            b = a; a = c;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}