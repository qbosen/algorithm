package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[2185] 统计包含给定前缀的字符串
/* ["pay","attention","practice","attend"],"at" */
public class CountingWordsWithAGivenPrefix{
    public static void main(String[] args) {
        Solution solution = new CountingWordsWithAGivenPrefix().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if(word.indexOf(pref)==0) count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}