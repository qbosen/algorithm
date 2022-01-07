package top.abosen.leetcode;

import java.util.*;
import top.abosen.leetcode.struct.*;

//[1614] 括号的最大嵌套深度
/* "(1+(2*3)+((8)/4))+1" */
public class MaximumNestingDepthOfTheParentheses{
    public static void main(String[] args) {
        Solution solution = new MaximumNestingDepthOfTheParentheses().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDepth(String s) {
        int leftCount = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                leftCount++;
                res = Math.max(res, leftCount);
            }else if(ch == ')'){
                leftCount --;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}