package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[面试题 01.09] 字符串轮转
/* "waterbottle","erbottlewat" */
public class StringRotationLcci{
    public static void main(String[] args) {
        Solution solution = new StringRotationLcci().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}