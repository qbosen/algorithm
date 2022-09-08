package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[667] 优美的排列 II
/* 3,1 */
public class BeautifulArrangementIi{
    public static void main(String[] args) {
        Solution solution = new BeautifulArrangementIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int t = n - k - 1;
        for (int i = 0; i < t; i++) ans[i] = i + 1;
        for (int i = t, a = n - k, b = n; i < n; ) {
            ans[i++] = a++;
            if (i < n) ans[i++] = b--;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}