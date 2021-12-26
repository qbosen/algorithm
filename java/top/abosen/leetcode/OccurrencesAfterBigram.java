package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[1078] Bigram 分词
/* "alice,is,a,good,girl,she,is,a,good,student","a","good" */
public class OccurrencesAfterBigram{
    public static void main(String[] args) {
        Solution solution = new OccurrencesAfterBigram().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findOcurrences(String text, String a, String b) {
        String[] ss = text.split(" ");
        int n = ss.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i + 2 < n; i++) {
            if (ss[i].equals(a) && ss[i + 1].equals(b)) list.add(ss[i + 2]);
        }
        return list.toArray(new String[list.size()]);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}