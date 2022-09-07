package leetcode.editor.cn;
		  
import java.util.*;
import java.util.stream.Collectors;

import leetcode.editor.cn.struct.*;
		  
//[1592] 重新排列单词间的空格
/* ",this,is,a,sentence," */
public class RearrangeSpacesBetweenWords{
    public static void main(String[] args) {
        Solution solution = new RearrangeSpacesBetweenWords().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorderSpaces(String text) {
        List<String> words = Arrays.stream(text.split("\\s+"))
                .filter(it -> it.length() > 0).toList();
        int spaces = text.length() - words.stream().mapToInt(String::length).sum();
        int space = words.size() == 1 ? 0 : spaces / (words.size() -1 );
        int remain = spaces - space * (words.size() - 1);
        return words.stream().collect(Collectors.joining(
                String.join("", Collections.nCopies(space, " ")),
                "",
                String.join("", Collections.nCopies(remain, " "))));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}