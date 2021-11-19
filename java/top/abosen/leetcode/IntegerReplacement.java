package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[397] 整数替换
/* 8 */
public class IntegerReplacement{
    public static void main(String[] args) {
        Solution solution = new IntegerReplacement().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Long, Integer> mem = new HashMap<>();

    public int integerReplacement(int n) {
        return dfs(n);
    }

    private int dfs(long n){
        if(n==1){
            return 0;
        }
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
      int ans = n%2==0?dfs(n/2) : Math.min(dfs(n+1),dfs(n-1));
        mem.put(n, ++ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}