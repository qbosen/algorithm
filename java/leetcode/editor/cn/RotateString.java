package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[796] 旋转字符串
/* "abcde","cdeab" */
public class RotateString{
    public static void main(String[] args) {
        Solution solution = new RotateString().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (goal + goal).contains(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}