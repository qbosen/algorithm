package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1447] 最简分数
/* 2 */
public class SimplifiedFractions{
    public static void main(String[] args) {
        Solution solution = new SimplifiedFractions().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int gcd(int a, int b) { // 欧几里得算法
        return b == 0 ? a : gcd(b, a % b);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) ans.add(i + "/" + j);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}