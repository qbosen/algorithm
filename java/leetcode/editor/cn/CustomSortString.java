package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[791] 自定义字符串排序
/* "cba","abcd" */
public class CustomSortString{
    public static void main(String[] args) {
        Solution solution = new CustomSortString().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String customSortString(String order, String s) {
        int[] od = new int[26];
        for (int i = 0; i < order.length(); i++) {
            od[order.charAt(i) - 'a'] = i+1;
        }

        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars, Comparator.comparing(i->od[i-'a']));
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}