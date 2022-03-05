package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[521] 最长特殊序列 Ⅰ
/* "aba","cdc" */
public class LongestUncommonSubsequenceI{
    public static void main(String[] args) {
        Solution solution = new LongestUncommonSubsequenceI().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}